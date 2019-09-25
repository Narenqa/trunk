package com.discovery.helpers;

import com.discovery.pages.DiscoveryHomePage;
import com.discovery.ui_tests.DriverScript;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DiscoveryNavigationHelper extends DriverScript {

	WebDriver driver = getDriver();

    DiscoveryHomePage discoveryHomePage = new DiscoveryHomePage(driver);

	WebDriverWait wait = new WebDriverWait(driver, 500);

    Logger log = Logger.getLogger(DiscoveryNavigationHelper.class);

    /*
        Helper to navigate to Discovery Homepage
        Verify Search box and search button are present
    */
    public void navigateToMyVideos(String myVideos) {
        log.info("************************ Helper to navigate to Discovery Homepage started ***********************");
        try{
            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getMenuIcon()));


            discoveryHomePage.getMenuIcon().click();
            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getMyVidesLink()));

            Assert.assertEquals(discoveryHomePage.getMyVidesLink().getText(), myVideos, "Link text ");
            discoveryHomePage.getMyVidesLink().click();
            waitForPageLoad();

        } catch(Exception e){
            Assert.fail("Navigate to Discovery Homepage failed");
        }
        log.info("************************ Helper to navigate to Discovery Homepage Completed ***********************");
    }


	public void navigateToDiscoveryHomePage(String url) {
        log.info("************************ Helper to navigate to Discovery Homepage started ***********************");
        try{
            goToURL(url);
            waitForPageLoad();
            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getHeaderLogo()));
            Assert.assertTrue(discoveryHomePage.getShowsLink().isDisplayed(),
                    "Cart count field is not displayed");

        } catch(Exception e){
            Assert.fail("Navigate to Discovery Homepage failed");
        }
        log.info("************************ Helper to navigate to Discovery Homepage Completed ***********************");
	}

    public void navigateToSeeAllShows(String seeAllShows, String showsLink) {
        log.info("************************ Helper to navigate to Discovery Homepage started ***********************");
        try{
            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getShowsLink()));
            String linkText = discoveryHomePage.getShowsLink().getText();
            Assert.assertEquals(linkText, showsLink, "Link text ");

            discoveryHomePage.getShowsLink().click();
            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getSeeAllShowsButton()));
            Assert.assertTrue(discoveryHomePage.getSeeAllShowsButton().isEnabled(),
                    "Cart count field is not displayed");
            Assert.assertEquals(discoveryHomePage.getSeeAllShowsButton().getText(), seeAllShows, "Link text ");
            discoveryHomePage.getSeeAllShowsButton().click();

        } catch(Exception e){
            Assert.fail("Navigate to Discovery Homepage failed");
        }
        log.info("************************ Helper to navigate to Discovery Homepage Completed ***********************");
    }


    public void waitForPageLoad() {
        log.info("************************ Helper to search item from Discovery Homepage started ***********************");
        try{

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body")));

        }catch(Exception e){
            Assert.fail("Search in Discovery Homepage failed");
        }

        log.info("************************ Helper to search item from Discovery Homepage completed ***********************");
    }



}
