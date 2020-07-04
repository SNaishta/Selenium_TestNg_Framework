package com.webapp.constants;

public abstract class Globals {

    public static final String SAUCE_DEMO_URL = "https://www.saucedemo.com/";
    public static final String SAUCE_DEMO_CHECKOUT_COMPLETE_URL = "https://www.saucedemo.com/checkout-complete.html";

    public final static String currentUsersHomeDir = System.getProperty("user.dir");
    public final static String testDataPropertiesFolderPath = currentUsersHomeDir + "/src/main/resources/configfile/";

    public final static int GLOBAL_TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 3;
    public final static String CREDENTIALS_CONFIGFILE_PATH = testDataPropertiesFolderPath + "config.properties";
    public final static String STANDARD_USERNAME = "StandardUserName";
    public final static String STANDARD_PASSWORD = "Password";
    public final static String LOCKED_OUT_USERNAME = "LockedOutUserName";
    public final static String FIRSTNAME = "FirstName";
    public final static String LASTNAME = "LastName";
    public final static String POSTCODE = "PostCode";

    interface CUCUMBER {
        String CUCUMBER_TAG = System.getProperty("cucumber.options")
                .replaceAll("~", "")
                .replaceAll("--tags @", "")
                .replaceAll("-t @UnstableAndroid", "")
                .replaceAll("-t @UnstableIos", "");
    }
}
