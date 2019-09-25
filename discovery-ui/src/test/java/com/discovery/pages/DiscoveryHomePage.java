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
    WebElement headerLogo;

    @FindBy(css = "li.dscHeaderMain__showsLink")
    public WebElement showsLink;

	@FindBy(css = "a.dscShowsDropContent__seeAllShows")
	public WebElement seeAllShowsButton;

    @FindBy(css = "div.allShowsGrid__container")
    public WebElement seeAllGrid;

    @FindBy(xpath = "//div/a[contains(@href,\"apollo\")]")
    public WebElement tvShowsTitle;

    @FindBy(css = "li>svg.dscHeaderMain__iconMenu")
    public WebElement menuIcon;


    public WebElement getMyVidesLink() {
        return myVidesLink;
    }

    public void setMyVidesLink(WebElement myVidesLink) {
        this.myVidesLink = myVidesLink;
    }

    @FindBy(css = "a[href=\"/my-videos\"]")
    public WebElement myVidesLink;

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
