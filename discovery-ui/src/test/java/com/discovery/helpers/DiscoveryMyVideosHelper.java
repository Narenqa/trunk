package com.discovery.helpers;

import com.discovery.pages.DiscoveryMyVideosPage;
import com.discovery.ui_tests.DriverScript;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DiscoveryMyVideosHelper extends DriverScript {

	WebDriver driver = getDriver();

    DiscoveryMyVideosPage discoveryMyVideosPage = new DiscoveryMyVideosPage(driver);


	WebDriverWait wait = new WebDriverWait(driver, 500);

    Logger log = Logger.getLogger(DiscoveryMyVideosHelper.class);

    List<String> favoriteVideosTitle;

    /*
        Validate the favorite or unfavorite titles under “FAVORITE SHOWS”
     */
    public List<String> getFavoriteVideosTitle(String title) {
        log.info("************************ Helper to getFavoriteVideosTitle started ***********************");
        try{
            wait.until(ExpectedConditions.visibilityOf(discoveryMyVideosPage.getFavoriteShowsCarousel()));
            Assert.assertTrue(discoveryMyVideosPage.getFavoriteShowsHeading().isDisplayed(), "Element is not present");
            String heading = discoveryMyVideosPage.getFavoriteShowsHeading().getText();
            Assert.assertEquals(heading.toLowerCase(), title.toLowerCase(), "Link text is not matching");
            wait.until(ExpectedConditions.visibilityOf(discoveryMyVideosPage.getFavoriteShowsCarouselContent()));
            List<WebElement> elementList = discoveryMyVideosPage.getMyVideosContentBox();
            favoriteVideosTitle = new ArrayList<>();
            int i = 1;
            for(WebElement element: elementList){
                System.out.println(element);
                Actions action = new Actions(driver);
                action.moveToElement(getDriver().findElement(By.xpath("//div[contains(@class,'carousel__content')]/div["+i+"]"))).perform();

                String showTitle = getDriver().findElement(By.xpath("//div[contains(@class,'carousel__content')]/div["+i+"]//h3/div")).getText();
                favoriteVideosTitle.add(showTitle.toLowerCase());
                i++;
            }

        } catch(Exception e){
            log.error(e.getMessage());
        }
        log.info("************************ Helper to getFavoriteVideosTitle started ***********************");
        return favoriteVideosTitle;
    }

}
