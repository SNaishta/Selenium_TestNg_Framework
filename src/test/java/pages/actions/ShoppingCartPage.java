package pages.actions;

import com.webapp.browser.DriverHelper;
import pages.objects.ShoppingCartPageObject;

public class ShoppingCartPage extends ShoppingCartPageObject {

    DriverHelper driverHelper;

    public ShoppingCartPage(DriverHelper driverHelper) {
        this.driverHelper = driverHelper;
    }

    public void checkOut() {
        driverHelper.click(checkoutButton);
    }

}
