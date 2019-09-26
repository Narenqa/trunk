package com.discovery.helpers;

import com.discovery.pages.DiscoveryHomePage;
import com.discovery.ui_tests.DriverScript;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class DiscoveryHelper extends DriverScript {

	WebDriver driver = getDriver();

    DiscoveryHomePage discoveryHomePage = new DiscoveryHomePage(driver);

	WebDriverWait wait = new WebDriverWait(driver, 500);

    Logger log = Logger.getLogger(DiscoveryHelper.class);


	public void scrollToPopularShows() {
        log.info("************************ Helper to navigate to Discovery Homepage started ***********************");
        try{
            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getHeaderLogo()));

            Actions actions = new Actions(driver);
            actions.moveToElement(discoveryHomePage.getPopularShowsCarousel());
            actions.perform();
            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getPopularShowsCarousel()));
            Assert.assertTrue(discoveryHomePage.getPopularShowsRightArrow().isDisplayed(),
                    "Cart count field is not displayed");

        } catch(Exception e){
            log.error(e.getMessage());
        }
        log.info("************************ Helper to navigate to Discovery Homepage Completed ***********************");
	}

	/*
	    Helper to navigate to popular show last video
	*/
    public void goToPopularShowLastVideo() {
        log.info("************************ Helper to navigate to Discovery Homepage started ***********************");
        try{

            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getPopularShowsCarousel()));
            Assert.assertTrue(discoveryHomePage.getPopularShowsRightArrow().isDisplayed(),
                    "Cart count field is not displayed");

            List<WebElement> elementList = discoveryHomePage.getPopularShowsDots();

            int size = elementList.size();
            int i = 1;
            while(i<=size){
                discoveryHomePage.getPopularShowsRightArrow().click();
                wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getPopularShowsLeftArrow()));
                Thread.sleep(200);
                i++;
            }
            System.out.println("Outside while loop");
        } catch(Exception e){
            log.error(e.getMessage());
        }
        log.info("************************ Helper to navigate to Discovery Homepage Completed ***********************");
    }

    public void clickExploreTheShowButton(String label) {
        log.info("************************ Helper to navigate to Discovery Homepage started ***********************");
        try{
            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getPopularShowsExploreButton()));
            Assert.assertEquals(discoveryHomePage.getPopularShowsExploreButton().getText().toLowerCase(), label.toLowerCase(),
                    "label is not as expected");
            discoveryHomePage.getPopularShowsExploreButton().click();
            waitForPageToLoad();

        } catch(Exception e){
            log.error(e.getMessage());
        }
        log.info("************************ Helper to navigate to Discovery Homepage Completed ***********************");
    }

}
