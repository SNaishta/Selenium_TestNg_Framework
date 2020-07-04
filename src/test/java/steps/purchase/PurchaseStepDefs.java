package steps.purchase;

import com.webapp.browser.DriverHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.actions.*;

public class PurchaseStepDefs {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private DriverHelper driverHelper;
    private ShoppingCartPage shoppingCartPage;
    private CheckOutPage checkOutPage;
    private OrderConfirmationPage orderConfirmationPage;

    public PurchaseStepDefs(LoginPage loginPage, ProductsPage productsPage,
                            DriverHelper driverHelper, ShoppingCartPage shoppingCartPage,
                            CheckOutPage checkOutPage,
                            OrderConfirmationPage orderConfirmationPage) {
        this.loginPage = loginPage;
        this.productsPage = productsPage;
        this.driverHelper = driverHelper;
        this.shoppingCartPage = shoppingCartPage;
        this.checkOutPage = checkOutPage;
        this.orderConfirmationPage = orderConfirmationPage;
    }

    @Given("I login to the application as ([^\"]*)")
    public void iLoginToTheApplicationAs(String userType) {
        Assert.assertTrue(driverHelper.isPageDisplayed(),"Login Page of the application displayed");
        loginPage.enterUserCredentials(userType);
    }

    @And("sort the products by ([^\"]*) Price")
    public void sortTheProductsByHighToLowPrice(String sortOrder) {
        productsPage.sortProductsByPrice();
        productsPage.setSortOrder(sortOrder);
        Assert.assertTrue(productsPage.validateListIsSorted());
    }

    @And("add the cheapest and the (\\d+) costliest products to the basket")
    public void addTheCheapestAndTheCostliestProductsToTheBasket(Integer index) {
        Assert.assertTrue(productsPage.pickCheapestAndNthItemFromtheInventory(index));
    }

    @When("I complete the checkout process with my information")
    public void iCompleteTheCheckoutProcessWithMyInformation() {
        shoppingCartPage.checkOut();
        checkOutPage.enterUserDetails();
    }

    @And("confirm the transaction details")
    public void confirmTheTransactionDetails() {
        Assert.assertTrue(checkOutPage.confirmDetails());
        checkOutPage.finishPayment();
    }

    @Then("my purchase is complete")
    public void myPurchaseIsComplete() {
        Assert.assertTrue(orderConfirmationPage.isOrderConfirmed());
    }
}
