package com.webapp.browser;

import com.webapp.configreader.PropertiesReaderWriter;
import com.webapp.configuration.webdriver.WebDriverBuilder;
import com.webapp.constants.Globals;
import com.webapp.helper.exceptions.LoggedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.webapp.constants.Globals.SAUCE_DEMO_URL;

public class DriverHelper {

    public WebDriver driver;
    private static Logger logger = LogManager.getLogger();
    public JavascriptExecutor javascriptExecutor;
    public WebDriverWait wait;

    public DriverHelper() {
        driver = WebDriverBuilder.getWebDriver();
        wait = new WebDriverWait( driver, 25);
    }

    public void loadPage() {
        driver.get(SAUCE_DEMO_URL);
    }

    public boolean isPageDisplayed() {
        sleep(500);
        return waitForPageToLoad() && isUrlCorrect() && isTitlePresent();
    }

    public void sleep(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new LoggedException("Could not sleep thread - " + e.getMessage());
        }
    }

    protected boolean waitForPageToLoad() {
        ExpectedCondition<Boolean> pageLoaded = webDriver -> javascriptExecutor.executeScript("return document.readyState")
                .toString().equals("complete");
        try {
            return wait.until(pageLoaded);
        } catch (Exception e) {
            return true;
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String elementName) {
        driver.findElement(locator).sendKeys(elementName);
    }


    public boolean isTitlePresent() {
        return !driver.getTitle().isEmpty();
    }

    public boolean isUrlCorrect() {
        try {
            Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(SAUCE_DEMO_URL));
            return true;
        } catch (Exception e) {
            throw new LoggedException("Incorrect URL - " + e.getMessage());
        }
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public String getFirstName() {
        return PropertiesReaderWriter.getProperties(Globals.FIRSTNAME, Globals.CREDENTIALS_CONFIGFILE_PATH);
    }

    public String getLastName() {
        return PropertiesReaderWriter.getProperties(Globals.LASTNAME, Globals.CREDENTIALS_CONFIGFILE_PATH);
    }

    public String getPostcode() {
        return PropertiesReaderWriter.getProperties(Globals.POSTCODE, Globals.CREDENTIALS_CONFIGFILE_PATH);
    }

    public String regexTo(String temp) {
        return temp.replaceAll("[^a-zA-Z0-9.]", " ");
    }

    public static int getRandomInt(int min, int max) {
        java.util.Random random = new java.util.Random();
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public String getCurrentPage() {
        return driver.getCurrentUrl();
    }

}


