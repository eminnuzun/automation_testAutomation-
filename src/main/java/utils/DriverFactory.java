package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    static WebDriver driver;
    static Properties properties;
    ChromeOptions chromeOptions;

    DesiredCapabilities capabilities;
    //String browsers= "Firefox";

    @Before
    public void setUp(){
        String downloadDir = System.getProperty("user.dir") + "/downloads";
        createFolderIfNotExists(downloadDir);
        driver = new ChromeDriver(chromeOptions());
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public ChromeOptions chromeOptions() {
        chromeOptions = new ChromeOptions();
        capabilities = DesiredCapabilities.chrome();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        chromeOptions.setExperimentalOption("prefs", prefs);
        //String downloadFilepath = "./desktop";
        String downloadDir = System.getProperty("user.dir") + "\\downloads";
        createFolderIfNotExists(downloadDir);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_settings.popups", 0);
        System.out.println("donlonad "+downloadDir);
        prefs.put("download.default_directory", downloadDir);
        //chromeOptions.addArguments("--kiosk");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-fullscreen");
        // chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        // chromeOptions.setExperimentalOption("useAutomationExtension", false);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        chromeOptions.merge(capabilities);
        return chromeOptions;


    }

    public static void createFolderIfNotExists(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    @After
    public void after(){
        driver.quit();
    }
}