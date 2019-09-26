package com.discovery.steps;

import com.discovery.constants.DiscoveryConstants;
import com.discovery.helpers.*;
import com.discovery.pages.DiscoveryEpisodePage;
import com.discovery.ui_tests.DriverScript;
import com.discovery.ui_tests.Utils;
import com.opencsv.CSVWriter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by narendraguntaka on 25/09/19.
 */
public class DiscoveryPopularShowsSteps extends DriverScript{

    DiscoveryHelper discoveryHelper = new DiscoveryHelper();
    DiscoveryEpisodeHelper discoveryEpisodeHelper = new DiscoveryEpisodeHelper();


    @Then("^I scroll down to popular shows$")
    public void scrollToPopularShows(){
        discoveryHelper.scrollToPopularShows();
    }

    @Then("^Go to the last video by pressing the icon >$")
    public void goToLastVideo(){
        discoveryHelper.goToPopularShowLastVideo();
    }

    @Then("^Once you reach the last video click on \"([^\"]*)\"$")
    public void clickExploreTheShow(String label){
        System.out.println("In explore ");
        discoveryHelper.clickExploreTheShowButton(label);

    }

    @Then("^Click on \"([^\"]*)\" and you will see the list of shows$")
    public void clickOnShowMore(String label){
        discoveryEpisodeHelper.clickShowMoreButton(label);

    }

    @And("^Click on \"([^\"]*)\" again and few shows will be added$")
    public void clickOnShowMoreAgain(String label){
        discoveryEpisodeHelper.clickShowMoreButton(label);

    }

    @And("^Create a new file and write all the show titles and duration into it$")
    public void writeAllTitlesAndDuration(){
        Map<String, String> map;
        map = discoveryEpisodeHelper.getAllEpisodeTitlesAndDurations();
        String[] header = { "Title", "Duration" };
        Utils.copyToCsv(DiscoveryConstants.EPISODES_CSV, header, map);
    }

}
