package pages.actions;

import com.webapp.browser.DriverHelper;
import pages.objects.OrderConfirmationPageObject;

import static com.webapp.constants.Globals.SAUCE_DEMO_CHECKOUT_COMPLETE_URL;

public class OrderConfirmationPage extends OrderConfirmationPageObject {

    DriverHelper driverHelper;

    public OrderConfirmationPage(DriverHelper driverHelper) {
        this.driverHelper= driverHelper;
    }

    public boolean isOrderConfirmed() {
        driverHelper.isTitlePresent();
        return driverHelper.getCurrentPage().equalsIgnoreCase(SAUCE_DEMO_CHECKOUT_COMPLETE_URL);
    }
}
