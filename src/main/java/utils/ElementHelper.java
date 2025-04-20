package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.HomePage;

import java.io.File;

public class ElementHelper {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.action = new Actions(driver);

    }
    public String waitForVisibilityAndGetText(By locator) throws Exception {
        String text;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            text=element.getText();
        }catch (Exception e) {
            logger.info("GetText hatasi: " + e.getMessage());
            throw new Exception("GetText hatasi:: " + e.getMessage());
        }
        return text;
    }


    public void waitForVisibilityAndClick(By locator) throws Exception {
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.click();
        } catch (TimeoutException e) {
            logger.info("Element görünmedi: " + locator);
            throw new Exception("Element görünmedi: " + locator);
        }
        catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            logger.info("JavaScript ile tıklandi");
        }
        catch (Exception e) {
            logger.info("Tıklama hatası: " + e.getMessage());
            throw new Exception("Tıklama hatası: " + e.getMessage());
        }
    }

    public void waitForVisibilityAndSendKey(By locator,String text) throws Exception {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.sendKeys(text);
        } catch (TimeoutException e) {
            logger.info("Element görünmedi ve text yazılamadı: " + locator);
            throw new Exception("Element görünmedi ve text yazılamadı: " + locator);
        } catch (Exception e) {
            logger.info("Text yazılamadı hatası: " + e.getMessage());
            throw new Exception("Text yazılamadı hatası: " + e.getMessage());
        }
    }

    public void waitForVisibilityAndSelectInList(By locator,String value) throws Exception {
        try {
            WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Select select = new Select(dropdown);
            select.selectByVisibleText(value);
        } catch (TimeoutException e) {
            logger.info("Element görünmedi ve select secilemedi: " + locator);
            throw new Exception("Element görünmedi ve select secilemedi: " + locator);
        } catch (Exception e) {
            logger.info("Select secilemedi hatası: " + e.getMessage());
            throw new Exception("Select secilemedi hatası: " + e.getMessage());
        }
    }

    public void assertElementIsVisible(By locator) {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Assert.assertTrue(element.isDisplayed(), "Element görünür değil: " + locator);
        } catch (Exception e) {
            Assert.fail("Element görünür değil veya bulunamadı: " + locator);
        }
    }

    public void assertElementCheckValueWithSavedItem(String elementText,String kayitliText) {
        if(elementText.contains(kayitliText)){
            Assert.assertTrue(true);
            logger.info(elementText +" texti "+kayitliText + " textini iceriyor");
        }
        else{
            Assert.fail(elementText +" texti "+kayitliText + " textini icermiyor");
        }

    }

    public void checkDownloads(String dosyaAdi) throws InterruptedException {
        String downloadDir = System.getProperty("user.dir") + "\\downloads";
        boolean fileExists = waitForFileDownload(downloadDir, dosyaAdi, 10);
        Assert.assertTrue(fileExists, "Dosya indirilemedi!");
    }

    public static boolean waitForFileDownload(String folderPath, String fileName, int maxWaitSeconds) throws InterruptedException {
        File file = new File(folderPath + "/" + fileName);

        int waited = 0;
        while (!file.exists() && waited < maxWaitSeconds) {
            Thread.sleep(1000); // 1 saniye bekle
            waited++;
        }
        return file.exists();
    }


    public static void deleteIfExists(String fileName) {
        String folderPath = System.getProperty("user.dir") + "\\downloads";
        logger.info("path: "+folderPath);
            File file = new File(folderPath + "/" + fileName);
            if (file.exists()) {
                if (file.delete()) {
                    logger.info("Eski dosya silindi: " + file.getName());
                } else {
                    logger.info("Dosya silinemedi: " + file.getName());
                }
            } else {
                logger.info("Silinecek dosya yok: " + file.getName());
            }
        }



    //-------------------------------

    public WebElement presenceElement(By key){
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    public WebElement findElement(By key){
        WebElement element = presenceElement(key);
        return element;

    }
    public void click(By key){
        findElement(key).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendKey(By key,String text){
        findElement(key).sendKeys(text);
    }

    public void checkVisible(By key){
        wait.until(ExpectedConditions.visibilityOf(findElement(key)));
    }

    public void moveToElement(By key){
        WebElement element = findElement(key);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
