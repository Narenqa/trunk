package com.discovery.helpers;

import com.discovery.pages.DiscoveryHomePage;
import com.discovery.pages.DiscoveryTvShowPage;
import com.discovery.ui_tests.DriverScript;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DiscoveryTvShowsHelper extends DriverScript {

	WebDriver driver = getDriver();

    DiscoveryHomePage discoveryHomePage = new DiscoveryHomePage(driver);
    DiscoveryTvShowPage discoveryTvShowPage = new DiscoveryTvShowPage(driver);

	WebDriverWait wait = new WebDriverWait(driver, 500);

    Logger log = Logger.getLogger(DiscoveryTvShowsHelper.class);

    List<String> list;
    List<String> favoriteVideosTitle;

    /*
        Helper to Wait till the page loads and then select the shows which contain "APOLLO"
    */
    public void selectShowByTitle(String showTitle) {
        log.info("************************ Helper to search item from Discovery Homepage started ***********************");
        try{

            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getSeeAllGrid()));
            System.out.println("Scroll down page");
            scrollDownPage();
            System.out.println("Scroll down page complete");
            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getTvShowsTitle()));
            List<WebElement> elementList = getDriver().findElements(By.xpath("//div/a[contains(@href,'"+showTitle.toString()+"')]"));

            list = new ArrayList<>();
            for(WebElement element: elementList){
                System.out.println(element);
                String href = element.getAttribute("href");
                list.add(href);

            }

        }catch(Exception e){
            log.error(e.getMessage());
        }

        log.info("************************ Helper to search item from Discovery Homepage completed ***********************");
    }

    /*
        Store all the favorite or unfavorite done titles in list.
    */
    public List<String> addFavoriteUnfavoriteShows() {
        log.info("************************ Helper to search item from Discovery Homepage started ***********************");
        try{
            favoriteVideosTitle = new ArrayList<>();
            for(String href: list){
                openLinkInNewWindow(href);

                wait.until(ExpectedConditions.visibilityOf(discoveryTvShowPage.getHeroImage()));
                if(discoveryTvShowPage.getHeroImagePlusIcon().isEnabled()){
                    discoveryTvShowPage.getHeroImagePlusIcon().click();
                    wait.until(ExpectedConditions.visibilityOf(discoveryTvShowPage.getHeroImageLogo()));
                    String favoriteVideoTitle = discoveryTvShowPage.getHeroImageLogo().getAttribute("alt");
                    favoriteVideosTitle.add(favoriteVideoTitle.toLowerCase());
                    Assert.assertTrue(discoveryTvShowPage.getHeroImageMinusIcon().isDisplayed());
                }else {
                    Assert.assertTrue(discoveryTvShowPage.getHeroImageMinusIcon().isDisplayed(),
                            "Best Seller Item Heading is not displayed");
                    discoveryTvShowPage.getHeroImageMinusIcon().click();
                    Assert.assertTrue(discoveryTvShowPage.getHeroImagePlusIcon().isDisplayed());
                }

            }
            switchToParentWindow();
        }catch(Exception e){
            log.error(e.getMessage());
        }

        log.info("************************ Helper to search item from Discovery Homepage completed ***********************");
        return favoriteVideosTitle;
    }


}
