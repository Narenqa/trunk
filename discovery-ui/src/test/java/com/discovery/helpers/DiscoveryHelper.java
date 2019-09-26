package com.discovery.helpers;

import com.discovery.pages.DiscoveryHomePage;
import com.discovery.ui_tests.DriverScript;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class DiscoveryHelper extends DriverScript {

	WebDriver driver = getDriver();

    DiscoveryHomePage discoveryHomePage = new DiscoveryHomePage(driver);

	WebDriverWait wait = new WebDriverWait(driver, 500);

    Logger log = Logger.getLogger(DiscoveryHelper.class);


	public void scrollToPopularShows() {
        log.info("************************ Helper to navigate to Discovery Homepage started ***********************");
        try{
            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getHeaderLogo()));
            System.out.println("Scroll down");
            scrollDownPage();
            System.out.println("Scroll down page");
            scrollToBottom();
            System.out.println("Scroll down complete");
            scrollUpPage();
            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getPopularShowsCarousel()));
            Assert.assertTrue(discoveryHomePage.getPopularShowsRightArrow().isDisplayed(),
                    "Cart count field is not displayed");

        } catch(Exception e){
            log.error(e.getMessage());
        }
        log.info("************************ Helper to navigate to Discovery Homepage Completed ***********************");
	}

    public void goToLastVideo() {
        log.info("************************ Helper to navigate to Discovery Homepage started ***********************");
        try{

            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getPopularShowsCarousel()));
            Assert.assertTrue(discoveryHomePage.getPopularShowsRightArrow().isDisplayed(),
                    "Cart count field is not displayed");
            while (discoveryHomePage.getPopularShowsRightArrow().isDisplayed()){
                discoveryHomePage.getPopularShowsRightArrow().click();
                wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getPopularShowsLeftArrow()));
            }

        } catch(Exception e){
            log.error(e.getMessage());
        }
        log.info("************************ Helper to navigate to Discovery Homepage Completed ***********************");
    }

    public void clickExploreTheShowButton(String label) {
        log.info("************************ Helper to navigate to Discovery Homepage started ***********************");
        try{

            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getPopularShowsExploreButton()));
            Assert.assertEquals(discoveryHomePage.getPopularShowsExploreButton().getText(), label,
                    "label is not as expected");
            discoveryHomePage.getPopularShowsExploreButton().click();
            waitForPageToLoad();

        } catch(Exception e){
            log.error(e.getMessage());
        }
        log.info("************************ Helper to navigate to Discovery Homepage Completed ***********************");
    }

}
