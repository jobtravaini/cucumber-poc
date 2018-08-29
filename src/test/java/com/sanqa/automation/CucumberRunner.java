package com.sanqa.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features" },
        plugin = { "pretty", "json:target/cucumber-report/Cucumber-Report.json", "html:target/cucumber-report/Cucumber-Report.html" },
        glue = { "com/sanqa/automation/stepdef" })
public class CucumberRunner {

}