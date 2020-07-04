package pages.actions;

import com.webapp.configreader.PropertiesReaderWriter;
import com.webapp.browser.DriverHelper;
import com.webapp.constants.Globals;
import com.webapp.enums.UserType;
import pages.objects.LoginPageObject;

import static com.webapp.enums.UserType.getShortName;

public class LoginPage extends LoginPageObject {

    public DriverHelper driverHelper;

    public LoginPage(DriverHelper driverHelper) {
        this.driverHelper = driverHelper;
        driverHelper.loadPage();
    }

    public void enterUserCredentials(String userType) {
        UserType user = getShortName(userType);
        String type = user.getShortName();

        switch (type) {
            case "standard":
            String standard_username = PropertiesReaderWriter.getProperties(Globals.STANDARD_USERNAME, Globals.CREDENTIALS_CONFIGFILE_PATH);
                driverHelper.sendKeys(usernameField, standard_username);
                break;
            case "LockedOut":
                String lockedOut_username = PropertiesReaderWriter.getProperties(Globals.LOCKED_OUT_USERNAME, Globals.CREDENTIALS_CONFIGFILE_PATH);
                driverHelper.sendKeys(usernameField,lockedOut_username );
                break;
        }
        String password = PropertiesReaderWriter.getProperties(Globals.STANDARD_PASSWORD, Globals.CREDENTIALS_CONFIGFILE_PATH);
        driverHelper.sendKeys(passwordField, password);
        driverHelper.click(loginButton);
    }
}
