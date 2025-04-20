package stepdefs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ElementHelper;

public class HomePageStepDefinitions {
    private static final Logger logger = LoggerFactory.getLogger(HomePageStepDefinitions.class);

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    ElementHelper elementHelper = new ElementHelper(driver);

    @Given("user at home page")
    public void userAtHomePage() {

    }


    @When("accept cookies")
    public void acceptCookies() {
        //homePage.acceptCookies();
    }


    @When("{string} elementine tıkla")
    public void elementineTikla(String elementName) throws Exception {
        logger.info(elementName + " elementine tıkla metodu calistirildi");
        elementHelper.waitForVisibilityAndClick(homePage.getElement(elementName));
        logger.info(elementName + " elementine tiklandi");
    }

    @When("{string} elementine {string} textini yaz")
    public void elementineTextiYaz(String elementName, String text) throws Exception {
        logger.info(elementName + " elementine yaz metodu calistirildi");
        elementHelper.waitForVisibilityAndSendKey(homePage.getElement(elementName), text);
        logger.info(elementName + " elementine" + text + "yazildi");
    }

    @When("{string} saniye bekle")
    public void bekle(String saniye) throws InterruptedException {
        Integer saniyeInt = Integer.parseInt(saniye);
        Thread.sleep(saniyeInt * 1000);
    }

    @When("{string}'listesinde {string} degeri secilir")
    public void selectIcındenValueSec(String elementName, String value) throws Exception {
        logger.info(elementName + " select elementinde " + value + " degeri secilme islemi baslatildi");
        elementHelper.waitForVisibilityAndSelectInList(homePage.getElement(elementName), value);
        logger.info(elementName + " select elementinde " + value + " degeri secilme islemi gerceklesti");
    }

    @When("{string} elementinin görünür oldugu kontrol edilir")
    public void elementinGorundugunuKontrolEt(String elementName) throws Exception {
        logger.info(elementName + " elementinin görünür oldugu kontrol edilir");
        elementHelper.assertElementIsVisible(homePage.getElement(elementName));
        logger.info(elementName + " elementi görünür");
    }

    @When("{string} elementinin degerini {string} keyine kaydet")
    public void elementinDegeriniKeyeKaydet(String elementName, String key) throws Exception {
        logger.info(elementName + " elementininin degerini" + key + " keyine kaydetme islemi baslatilmistir");
        homePage.setDataStore(elementHelper.waitForVisibilityAndGetText(homePage.getElement(elementName)), key);
        logger.info(elementName + " elementininin degerini" + key + " keyine kaydetme islemi tamamlanmıstır");
    }

    @When("{string} elementinin degerinin kaydedilmis {string} keyin degerini icerdigini kontrol et")
    public void elementinDegerininKaydedilmisDegereEsitOldugunuKontrolEt(String elementName, String key) throws Exception {
        logger.info(elementName + " elementininin degerini" + key + " keyin degerini icerdigini kontrolu basladi ");
        elementHelper.assertElementCheckValueWithSavedItem(elementHelper.waitForVisibilityAndGetText(homePage.getElement(elementName)), homePage.getDataStore(key));
        logger.info(elementName + " elementininin degerini" + key + " keyin degerini icerdigini kontrolu tamamlandı ");
    }

    @When("{string} dosyasinin indigini kontrol et")
    public void dosyaninIndirildiginiKontrolEt(String dosyaAdi) throws Exception {
        logger.info(dosyaAdi + " dosyanin indirilmesi kontrolu basladi");
        elementHelper.checkDownloads(dosyaAdi);
        logger.info(dosyaAdi + " dosyanin indirilmesi kontrolu bitti");
    }

    @When("{string} dosyasini sil")
    public void dosyasiniSil(String dosyaAdi) throws Exception {
        logger.info(dosyaAdi + " dosyanin silinmesi  basladi");
        elementHelper.deleteIfExists(dosyaAdi);
        logger.info(dosyaAdi + " dosyanin silinmesi  bitti");
    }


}
