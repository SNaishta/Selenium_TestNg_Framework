package pages.objects;

import com.webapp.configuration.webdriver.WebDriverBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class OrderConfirmationPageObject {

    public WebDriver driver;

    @FindBy(className = "complete-header")
    public WebElement orderConfirmationText;

    @FindBy(className = "subheader")
    public WebElement orderConfirmationPageTitle;

    public OrderConfirmationPageObject() {
        this.driver = WebDriverBuilder.getWebDriver();
        PageFactory.initElements(driver, this);
    }

}
