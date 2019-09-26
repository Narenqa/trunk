package com.discovery.pages;

import com.discovery.ui_tests.DriverScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    private WebElement popularShowsDots;

    @FindBy(css = "div.popularShowsCarousel__main i.icon-arrow-left")
    private WebElement popularShowsLeftArrow;


    @FindBy(css = "div.popularShowsCarousel__main i.icon-arrow-right")
    private WebElement popularShowsRightArrow;

    @FindBy(css = "div.popularShowTile__showButtonWrapper button")
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

    public WebElement getPopularShowsDots() {
        return popularShowsDots;
    }

    public void setPopularShowsDots(WebElement popularShowsDots) {
        this.popularShowsDots = popularShowsDots;
    }


    public WebElement getPopularShowsCarousel() {
        return popularShowsCarousel;
    }

    public void setPopularShowsCarousel(WebElement popularShowsCarousel) {
        this.popularShowsCarousel = popularShowsCarousel;
    }

    public WebElement getMyVideosLink() {
        return myVideosLink;
    }

    public void setMyVideosLink(WebElement myVidesLink) {
        this.myVideosLink = myVidesLink;
    }

    @FindBy(css = "a[href=\"/my-videos\"]")
    public WebElement myVideosLink;

    public WebElement getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(WebElement menuIcon) {
        this.menuIcon = menuIcon;
    }

    public WebElement getHeaderLogo() {
        return headerLogo;
    }

    public void setHeaderLogo(WebElement headerLogo) {
        this.headerLogo = headerLogo;
    }

    public WebElement getShowsLink() {
        return showsLink;
    }

    public void setShowsLink(WebElement showsLink) {
        this.showsLink = showsLink;
    }

    public WebElement getSeeAllShowsButton() {
        return seeAllShowsButton;
    }

    public void setSeeAllShowsButton(WebElement seeAllShowsButton) {
        this.seeAllShowsButton = seeAllShowsButton;
    }

    public WebElement getSeeAllGrid() {
        return seeAllGrid;
    }

    public void setSeeAllGrid(WebElement seeAllGrid) {
        this.seeAllGrid = seeAllGrid;
    }

    public WebElement getTvShowsTitle() {
        return tvShowsTitle;
    }

    public void setTvShowsTitle(WebElement tvShowsTitle) {
        this.tvShowsTitle = tvShowsTitle;
    }


}
