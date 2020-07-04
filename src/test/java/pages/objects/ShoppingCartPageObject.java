package pages.objects;

import com.webapp.configuration.webdriver.WebDriverBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.util.List;

public class ShoppingCartPageObject {

    public WebDriver driver;

    protected static By ProductsCount = By.className("cart_list");
    protected static By yourCartPageTitle = By.className("subheader");
    protected static By checkoutButton = By.className("checkout_button");
    protected static By continueShoppingButton = By.className("btn_action checkout_button");

    public ShoppingCartPageObject() {
        this.driver = WebDriverBuilder.getWebDriver();
        PageFactory.initElements(driver, this);
    }

}
