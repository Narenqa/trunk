package com.discovery.steps;

import com.discovery.helpers.DiscoveryMyVideosHelper;
import com.discovery.helpers.DiscoveryNavigationHelper;
import com.discovery.helpers.DiscoveryTvShowsHelper;
import com.discovery.ui_tests.DriverScript;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

/**
 * Created by narendraguntaka on 25/09/19.
 */
public class DiscoveryCommonSteps extends DriverScript{

    DiscoveryNavigationHelper discoveryNavigationHelper = new DiscoveryNavigationHelper();


    @Given("^I navigate to \"([^\"]*)\"$")
    public void navigateToHomePage(String url){
        discoveryNavigationHelper.navigateToDiscoveryHomePage(url);
    }


    @Then("^I Wait till the page loads$")
    public void waitForPageLoad(){
        discoveryNavigationHelper.waitForPageLoad();
    }



}
