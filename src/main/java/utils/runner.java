package utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;


@CucumberOptions(
        features = {"src/test/features"},
        glue = {"stepdefs", "utils"},
        tags = "",
        plugin = {
                "summary","pretty","html:Reports/CucumberReport/Reports.html"

        }

)


public class runner extends AbstractTestNGCucumberTests {
    static WebDriver driver = DriverFactory.getDriver();
}
