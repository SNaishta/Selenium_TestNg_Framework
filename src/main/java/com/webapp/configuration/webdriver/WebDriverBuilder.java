package com.webapp.configuration.webdriver;

import com.webapp.constants.ThreadVariables;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import static com.webapp.constants.Globals.SAUCE_DEMO_URL;

public class WebDriverBuilder implements WebDriver {

    private WebDriver webDriver = null;
    private String browser;
    private MutableCapabilities options;
    private WebDriverWait wait;

    public WebDriverBuilder(String browser) {
        this.browser = browser;
        set_browser_properties();

        switch (browser) {
            case "chrome":
                webDriver = new ChromeDriver((ChromeOptions) options);
                break;
            case "firefox":
                webDriver = new FirefoxDriver((FirefoxOptions) options);
                break;
        }
        wait = new WebDriverWait(webDriver, 25);
    }

    private void set_browser_properties() {
        switch (this.browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();

                options = new ChromeOptions();
                ((ChromeOptions) options).addArguments("start-maximized");
                ((ChromeOptions) options).setAcceptInsecureCerts(true);
                ((ChromeOptions) options).setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
                ((ChromeOptions) options).addArguments("start-maximized");
                ((ChromeOptions) options).addArguments("disable-infobars");
                ((ChromeOptions) options).setProxy(null);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();

                options = new FirefoxOptions();
                ((FirefoxOptions) options).setAcceptInsecureCerts(true);
                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                break;

            default:
                System.out.println("[skipping test] " + browser + " is not a recognised web browser, please check config.");
        }
    }

    public boolean is_driver_enabled() {
        if (webDriver != null) {
            return true;
        }
        return false;
    }

    public static WebDriver getWebDriver() {
        return ThreadVariables.driver.get();
    }

    public void get(String url) { webDriver.get(SAUCE_DEMO_URL); }

    public String getCurrentUrl() { return webDriver.getCurrentUrl(); }

    public String getTitle() { return webDriver.getTitle(); }

    public List<WebElement> findElements(By by) { return webDriver.findElements(by); }

    @Override
    public WebElement findElement(By by) { return webDriver.findElement(by); }

    public String getPageSource() { return webDriver.getPageSource(); }

    public void close() { webDriver.close(); }

    public void quit() { webDriver.quit(); }

    public Set<String> getWindowHandles() { return null; }

    public String getWindowHandle() { return null; }

    public TargetLocator switchTo() { return null; }

    public Navigation navigate() { return null; }

    public Options manage() { return null; }

}


