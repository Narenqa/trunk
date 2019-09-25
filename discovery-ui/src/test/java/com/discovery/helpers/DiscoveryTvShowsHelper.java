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


    /*
        Helper to input search item
        Verify Search results info bar contains the input text
    */
    List<String> list;
    public void selectShow(String searchText) {
        log.info("************************ Helper to search item from Discovery Homepage started ***********************");
        try{

            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getSeeAllGrid()));
            System.out.println("Scroll down page");
            scrollDownPage();
            System.out.println("Scroll down page complete");
            wait.until(ExpectedConditions.visibilityOf(discoveryHomePage.getTvShowsTitle()));
            List<WebElement> elementList = getDriver().findElements(By.xpath("//div/a[contains(@href,'"+searchText.toString()+"')]"));

            list = new ArrayList<>();
            for(WebElement element: elementList){
                System.out.println(element);
                String href = element.getAttribute("href");
                list.add(href);

            }


        }catch(Exception e){
            throw new ElementNotVisibleException("Element not visible ");
        }

        log.info("************************ Helper to search item from Discovery Homepage completed ***********************");
    }

    List<String> favoriteVideosTitle;
    public List<String> addFavoriteUnfavoriteShows() {
        log.info("************************ Helper to search item from Discovery Homepage started ***********************");
        try{
            favoriteVideosTitle = new ArrayList<>();
            for(String href: list){
                System.out.println(href);
                openLinkInNewWindow(href);

                System.out.println(discoveryTvShowPage.getHeroImage());
                wait.until(ExpectedConditions.visibilityOf(discoveryTvShowPage.getHeroImage()));
                System.out.println(discoveryTvShowPage.heroImagePlusIcon);
                if(discoveryTvShowPage.heroImagePlusIcon.isEnabled()){

                    discoveryTvShowPage.getHeroImagePlusIcon().click();
                    wait.until(ExpectedConditions.visibilityOf(discoveryTvShowPage.getHeroImageLogo()));
                    String favoriteVideoTitle = discoveryTvShowPage.getHeroImageLogo().getAttribute("alt");
                    favoriteVideosTitle.add(favoriteVideoTitle.toLowerCase());

                    System.out.println("Wait for icon is displayed..");

//                    Assert.assertTrue(discoveryHomePage.getHeroImageMinusIcon().isDisplayed());
                }else {
                    System.out.println("Plus icon is displayed..");
                    Assert.assertTrue(discoveryTvShowPage.getHeroImageMinusIcon().isDisplayed(),
                            "Best Seller Item Heading is not displayed");
                    discoveryTvShowPage.getHeroImageMinusIcon().click();
                    Assert.assertTrue(discoveryTvShowPage.getHeroImagePlusIcon().isDisplayed());
                }

            }
            switchToParentWindow();
        }catch(Exception e){
            throw new ElementNotVisibleException("Element not visible ");
        }

        log.info("************************ Helper to search item from Discovery Homepage completed ***********************");
        return favoriteVideosTitle;
    }


}
