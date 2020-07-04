package runner;

import com.webapp.constants.ThreadVariables;
import com.webapp.configuration.webdriver.WebDriverBuilder;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"pretty", "json:target/cucumber-parallel/SauceDemo.json"},
        strict = true,
        monochrome = true,
        tags = {"@EndToEnd"}
)

public class CheckOutFunctionalTest extends AbstractTestNGCucumberTests {
    @BeforeClass(alwaysRun = true)
    @Parameters(value = "browser")
    public void setUp(String browserName) {
        ThreadVariables.driver.set(null);
        ThreadVariables.driver.set(new WebDriverBuilder(browserName));
        System.out.println(" ///////***************   Starting Test on : " + browserName + "     ***************//////");
    }

    @AfterClass(alwaysRun = true)
    @Parameters(value = "browser")
    public void tear_down(String browserName) {
        if (ThreadVariables.driver.get().is_driver_enabled()) {
            System.out.println(" ///////***************   Shutting Down : " + browserName + "   +  browser  ***************//////");

            ThreadVariables.driver.get().quit();
        }

    }
}