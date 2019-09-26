package com.discovery.pages;

import com.discovery.ui_tests.DriverScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by narendra on 24/09/2019.
 */
public class DiscoveryEpisodePage extends DriverScript {

    WebDriver driver;

    public DiscoveryEpisodePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getEpisodeList() {
        return episodeList;
    }

    @FindBy(css="ul.episodeList__list li.episodeVideoTile__wrapper")
    private List<WebElement> episodeList;

    @FindBy(css = "ul li.episodeVideoTile__wrapper")
    private WebElement episodeVideoWrapper;

    @FindBy(css = "p.minutes")
    private WebElement episodeDuration;

    @FindBy(css= "p.episodeTitle")
    private WebElement episodeTitle;

    public WebElement getEpisodeVideoWrapper() {
        return episodeVideoWrapper;
    }

    public WebElement getEpisodeDuration() {
        return episodeDuration;
    }

    public WebElement getEpisodeTitle() {
        return episodeTitle;
    }

    public WebElement getShowMoreButton() {
        return showMoreButton;
    }

    @FindBy(css = "li.episodeList__showMore button")
    private WebElement showMoreButton;


}
