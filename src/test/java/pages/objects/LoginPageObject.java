package pages.objects;

import com.webapp.configuration.webdriver.WebDriverBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

    private WebDriver driver;

    protected static By usernameField = By.id("user-name");
    protected static By passwordField = By.id("password");
    protected static By loginButton = By.className("btn_action");

    public LoginPageObject() {
        this.driver = WebDriverBuilder.getWebDriver();
        PageFactory.initElements(driver, this);
    }
}
