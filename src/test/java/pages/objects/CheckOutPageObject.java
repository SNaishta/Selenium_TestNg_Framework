package pages.objects;

import com.webapp.configuration.webdriver.WebDriverBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPageObject {

    public WebDriver driver;

    protected static By firstNameTextField = By.id("first-name");
    protected static By lastNameTextField = By.id("last-name");
    protected static By postCodeTextField = By.id("postal-code");
    protected static By continueButton = By.className("cart_button");
    protected static By inventory = By.className("inventory_item_name");
    protected static By finishButton = By.className("cart_button");

    public CheckOutPageObject() {
        this.driver = WebDriverBuilder.getWebDriver();
        PageFactory.initElements(driver, this);
    }

}
