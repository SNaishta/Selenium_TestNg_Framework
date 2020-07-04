package pages.objects;

import com.webapp.configuration.webdriver.WebDriverBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.util.List;

public class ProductsPageObject {

    public WebDriver driver;

    protected static By productSortDropdown = By.className("product_sort_container");
    protected static By inventoryPrice = By.className("inventory_item_price");
    protected static By viewCart = By.className("shopping_cart_container");
    protected static By inventoryCount = By.className("btn_inventory");


    public ProductsPageObject() {
        this.driver = WebDriverBuilder.getWebDriver();
        PageFactory.initElements(driver, this);
    }

}
