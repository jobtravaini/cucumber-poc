package com.sanqa.automation.page.base;

import com.sanqa.automation.driver.WebDriverWrapper;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {

    protected WebDriverWrapper driver;

    public PageObject(WebDriverWrapper driver) {
        this.driver = driver;
        this.driver.waitBrowserLoading();
        PageFactory.initElements(driver.getCoreDriver(), this);
    }

}
