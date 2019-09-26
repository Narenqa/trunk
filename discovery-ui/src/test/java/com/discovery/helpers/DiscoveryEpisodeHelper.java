package com.discovery.helpers;

import com.discovery.pages.DiscoveryEpisodePage;
import com.discovery.pages.DiscoveryHomePage;
import com.discovery.ui_tests.DriverScript;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.*;


public class DiscoveryEpisodeHelper extends DriverScript {

	WebDriver driver = getDriver();

    DiscoveryEpisodePage discoveryEpisodePage = new DiscoveryEpisodePage(driver);

	WebDriverWait wait = new WebDriverWait(driver, 500);

    Logger log = Logger.getLogger(DiscoveryEpisodeHelper.class);

    List<String> episodeTitles;
    List<String> episodeDurations;



    public void clickShowMoreButton(String label) {
        log.info("************************ Helper to click Show More button in episode page started ***********************");
        try{

            System.out.println("Scroll down complete");
            wait.until(ExpectedConditions.visibilityOf(discoveryEpisodePage.getShowMoreButton()));
            Assert.assertEquals(discoveryEpisodePage.getShowMoreButton().getText(), label,
                    "label is not as expected");
            discoveryEpisodePage.getShowMoreButton().click();
            waitForPageToLoad();

        } catch(Exception e){
            log.error(e.getMessage());
        }
        log.info("************************ Helper to click Show More button in episode page started Completed ***********************");
    }

    Map<String, String> map;
    public Map<String, String> getAllEpisodeTitlesAndDurations() {
        log.info("************************ Helper to get All visible Episode titles and duration in episode page started ***********************");
        try{

            wait.until(ExpectedConditions.visibilityOf(discoveryEpisodePage.getShowMoreButton()));

            List<WebElement> elementList = discoveryEpisodePage.getEpisodeList();
            episodeTitles = new ArrayList<>();
            episodeDurations = new ArrayList<>();
            map = new HashMap<>();
            int i = 1;
            for(WebElement element: elementList){
                getDriver().findElement(By.xpath("//ul[@class='episodeList__list']/li["+i+"]//p[@class='episodeTitle']"));
                String episodeTitle = getDriver().findElement(By.xpath("//ul[@class='episodeList__list']/li["+i+"]//p[@class='episodeTitle']")).getText();
                String episodeDuration = getDriver().findElement(By.xpath("//ul[@class='episodeList__list']/li["+i+"]//p[@class='minutes']")).getText();
                episodeTitles.add(episodeTitle.toLowerCase());
                episodeDurations.add(episodeDuration.toLowerCase());
                map.put(episodeTitle, episodeDuration);
                i++;
            }
            System.out.println(map);
            driver.quit();


        } catch(Exception e){
            log.error(e.getMessage());
        }
        log.info("************************ Helper to get All visible Episode titles and duration in episode page Completed ***********************");
        return map;
    }



}
