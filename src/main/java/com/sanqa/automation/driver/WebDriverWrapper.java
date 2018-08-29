package com.sanqa.automation.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverWrapper {

    private WebDriver driver;
    private long timeout = 10;

    WebDriverWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.get(url);
        waitBrowserLoading();
    }

    public void close() {
        driver.close();
    }

    public void clickOnElement(By element) {
        waitElementConditionClickable(element);
        driver.findElement(element).click();
    }

    public void sendKeysToElement(String input, By element) {
        clickOnElement(element);
        driver.findElement(element).sendKeys(input);
    }

    public void waitElementConditionClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitBrowserLoading() {
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public WebDriver getCoreDriver() {
        return driver;
    }

}
