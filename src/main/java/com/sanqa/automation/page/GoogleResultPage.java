package com.sanqa.automation.page;

import com.sanqa.automation.driver.WebDriverWrapper;
import com.sanqa.automation.page.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleResultPage extends PageObject {

    private static final String RESULT_LIST_FIELD_ID = "rso";
    private static final String RESULT_ENTITY_XPATH = "//h3/a";

    @FindBy(id=RESULT_LIST_FIELD_ID)
    private WebElement resultList;

    public GoogleResultPage(WebDriverWrapper driver) {
        super(driver);
    }

    public WebElement getResult(int index) {
       List<WebElement> elements = resultList.findElements(By.xpath(RESULT_ENTITY_XPATH));

       return elements.get(index);
    }

}
