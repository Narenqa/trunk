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
public class DiscoveryHomePage extends DriverScript {

    WebDriver driver;

    public DiscoveryHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "a.dscHeaderMain__headerLogo")
    private WebElement headerLogo;

    @FindBy(css = "li.dscHeaderMain__showsLink")
    private WebElement showsLink;

	@FindBy(css = "a.dscShowsDropContent__seeAllShows")
	private WebElement seeAllShowsButton;

    @FindBy(css = "div.allShowsGrid__container")
    private WebElement seeAllGrid;

    @FindBy(xpath = "//div/a[contains(@href,\"apollo\")]")
    private WebElement tvShowsTitle;

    @FindBy(css = "li>svg.dscHeaderMain__iconMenu")
    private WebElement menuIcon;


    @FindBy(css = "div.popularShowsCarousel__main")
    private WebElement popularShowsCarousel;

    @FindBy(css = "div.popularShowsCarousel__main li.popularShowsCarousel__dotInactive")
    private List<WebElement> popularShowsDots;

    @FindBy(css = "div.popularShowsCarousel__main i.icon-arrow-left")
    private WebElement popularShowsLeftArrow;


    @FindBy(css = "div.popularShowsCarousel__main i.icon-arrow-right")
    private WebElement popularShowsRightArrow;

    @FindBy(css = "div[aria-hidden='false'] div.popularShowTile__showButtonWrapper button")
    private WebElement popularShowsExploreButton;

    public WebElement getPopularShowsExploreButton() {
        return popularShowsExploreButton;
    }

    public WebElement getPopularShowsRightArrow() {
        return popularShowsRightArrow;
    }

    public WebElement getPopularShowsLeftArrow() {
        return popularShowsLeftArrow;
    }

    public List<WebElement> getPopularShowsDots() {
        return popularShowsDots;
    }

    public WebElement getPopularShowsCarousel() {
        return popularShowsCarousel;
    }

    public WebElement getMyVideosLink() {
        return myVideosLink;
    }


    @FindBy(css = "a[href=\"/my-videos\"]")
    public WebElement myVideosLink;

    public WebElement getMenuIcon() {
        return menuIcon;
    }

    public WebElement getHeaderLogo() {
        return headerLogo;
    }

    public WebElement getShowsLink() {
        return showsLink;
    }

    public WebElement getSeeAllShowsButton() {
        return seeAllShowsButton;
    }

    public WebElement getSeeAllGrid() {
        return seeAllGrid;
    }

    public WebElement getTvShowsTitle() {
        return tvShowsTitle;
    }



}
