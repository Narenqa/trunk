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
public class DiscoveryFavoriteShowsSteps extends DriverScript{

    DiscoveryNavigationHelper discoveryNavigationHelper = new DiscoveryNavigationHelper();
    DiscoveryMyVideosHelper discoveryMyVideosHelper = new DiscoveryMyVideosHelper();
    DiscoveryTvShowsHelper discoveryTvShowsHelper = new DiscoveryTvShowsHelper();
    List<String> favoriteShowsTitles;
    List<String> myVideosFavoriteShowsTitles;


    @And("^I select \"([^\"]*)\" available in \"([^\"]*)\" tab$")
    public void navigateToSeeAllShows(String seeAllShows, String showsLink){
        discoveryNavigationHelper.navigateToSeeAllShows(seeAllShows, showsLink);
    }

    @Then("^select the shows which contain \"([^\"]*)\"$")
    public void selectShows(String showTitle){
        discoveryTvShowsHelper.selectShowByTitle(showTitle.toLowerCase());
    }


    @Then("^Verify the favorite status and Add shows to favorite or unfavorite$")
    public void addFavoriteShows(){
        favoriteShowsTitles = discoveryTvShowsHelper.addFavoriteUnfavoriteShows();
    }

    @Then("^I goto \"([^\"]*)\"$")
    public void navigateToMyVideos(String myVideos){
        discoveryNavigationHelper.navigateToMyVideos(myVideos);
    }

    @Then("^Validate the favorite or unfavorite titles under \"([^\"]*)\"$")
    public void verifyMyVideosFavoriteTitles(String heading){
        myVideosFavoriteShowsTitles = discoveryMyVideosHelper.getFavoriteVideosTitle(heading);
        Collections.sort(favoriteShowsTitles);
        Collections.sort(myVideosFavoriteShowsTitles);
        Assert.assertTrue(favoriteShowsTitles.equals(myVideosFavoriteShowsTitles), "Titles are not matched");
    }

}
