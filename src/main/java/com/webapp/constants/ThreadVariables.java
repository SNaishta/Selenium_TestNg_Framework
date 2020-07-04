package com.webapp.constants;

import com.webapp.configuration.webdriver.WebDriverBuilder;

public abstract class ThreadVariables {

    public static final ThreadLocal<WebDriverBuilder> driver = new ThreadLocal<>();
}
