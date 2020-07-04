package pages.actions;

import com.webapp.browser.DriverHelper;
import pages.objects.CheckOutPageObject;

public class CheckOutPage extends CheckOutPageObject {

    DriverHelper driverHelper;

    public CheckOutPage( DriverHelper driverHelper) {
        this.driverHelper = driverHelper;
    }

    public void enterUserDetails() {
        driverHelper.sendKeys(firstNameTextField, driverHelper.getFirstName());
        driverHelper.sendKeys(lastNameTextField, driverHelper.getLastName());
        driverHelper.sendKeys(postCodeTextField, driverHelper.getPostcode());
        driverHelper.click(continueButton);
    }

    public boolean confirmDetails() {
        return driverHelper.findElement(inventory).isDisplayed();
    }

    public void finishPayment() {
        driverHelper.click(finishButton);
    }

}
