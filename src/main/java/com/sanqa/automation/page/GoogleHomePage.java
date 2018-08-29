package com.sanqa.automation.page;

import com.sanqa.automation.driver.WebDriverWrapper;
import com.sanqa.automation.page.base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends PageObject {

    private static final String SEARCH_TEXT_FIELD_ID = "lst-ib";

    @FindBy(id=SEARCH_TEXT_FIELD_ID)
    private WebElement searchTextField;

    public GoogleHomePage(WebDriverWrapper driver) {
        super(driver);
    }

    public void inputSearchParameter(String input) {
        searchTextField.clear();
        searchTextField.sendKeys(input);
    }

    public GoogleResultPage search(String input) {
        inputSearchParameter(input);
        searchTextField.submit();

        return new GoogleResultPage(driver);
    }

    public String getTextFieldValue() {
        return searchTextField.getAttribute("value");
    }

}
