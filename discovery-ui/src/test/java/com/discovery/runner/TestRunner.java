package com.discovery.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by narendraguntaka on 26/09/19.
 */
@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/java/com/discovery/features"}, glue = {"com.discovery.steps"}, plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true)
public class TestRunner {

}
