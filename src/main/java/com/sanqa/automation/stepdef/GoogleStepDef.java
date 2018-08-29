package com.sanqa.automation.stepdef;

import com.sanqa.automation.driver.DriverFactory;
import com.sanqa.automation.driver.WebDriverWrapper;
import com.sanqa.automation.page.GoogleHomePage;
import com.sanqa.automation.page.GoogleResultPage;
import com.sanqa.automation.world.World;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class GoogleStepDef {

    private DriverFactory driverFactory = DriverFactory.getInstance();

    private static final String GOOGLE_URL = "http://www.google.com";
    private World world;

    public GoogleStepDef(World world) {
        this.world = world;
    }

    @Given("^User opens the browser$")
    public void instantiateDriverAndUrl() throws Exception {
        WebDriverWrapper driver = driverFactory.openChrome();

        world.putValue("driver", driver);
    }

    @Given("^User opens Google$")
    public void openGoogle() {
        WebDriverWrapper driver = driverFactory.openChrome();
        driver.openUrl(GOOGLE_URL);

        world.putValue("driver", driver);
    }

    @And("^Enters Google URL$")
    public void inputGoogleURL() {
        world.putValue("url", GOOGLE_URL);
    }

    @When("^URL is open$")
    public void openWebsite() {
        WebDriverWrapper driver = world.getObject("driver", WebDriverWrapper.class);

        String url = world.getString("url");
        driver.openUrl(url);
    }

    @When("^Searching for \"([^\"]*)\"$")
    public void searchWithParameter(String parameter) {
        WebDriverWrapper driver = world.getObject("driver", WebDriverWrapper.class);
        GoogleHomePage googlePage = new GoogleHomePage(driver);
        GoogleResultPage resultPage = googlePage.search(parameter);

        world.putValue("resultPage", resultPage);
    }

    @Then("^The first result is Google Homepage$")
    public void assertFirstGoogleResult() {
        GoogleResultPage resultPage = world.getObject("resultPage", GoogleResultPage.class);

        WebElement firstResult = resultPage.getResult(1);

        String link = firstResult.getAttribute("href");

        Assert.assertNotNull(link);
        boolean isGoogleRelated = link.contains("google");
        Assert.assertTrue(isGoogleRelated);
    }

    @Then("^The User can type the Search Parameter \"([^\"]*)\"$")
    public void insertValueOnSearchField(String input) {
        WebDriverWrapper driver = world.getObject("driver", WebDriverWrapper.class);
        GoogleHomePage googlePage = new GoogleHomePage(driver);
        googlePage.inputSearchParameter(input);
        Assert.assertEquals(input, googlePage.getTextFieldValue());
    }

    @After
    public void destroyDriver() {
        WebDriverWrapper driver = world.getObject("driver", WebDriverWrapper.class);
        if (null != driver) {
            driver.close();
        }
    }
}
