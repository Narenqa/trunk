package com.discovery.pages;

import com.discovery.ui_tests.DriverScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by narendra on 24/09/2019.
 */
public class DiscoveryTvShowPage extends DriverScript {

    WebDriver driver;

    public DiscoveryTvShowPage(WebDriver driver) {
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



    @FindBy(css = "div.showHero__showImage")
    public WebElement heroImage;

    @FindBy(css = "div.showHero__main i.icon-plus")
    public WebElement heroImagePlusIcon;

    @FindBy(css = "div.showHero__main i.icon-minus")
    public WebElement heroImageMinusIcon;

    public WebElement getHeroImageLogo() {
        return heroImageLogo;
    }

    public void setHeroImageLogo(WebElement heroImageLogo) {
        this.heroImageLogo = heroImageLogo;
    }

    @FindBy(css = "img.showHero__showLogo")
    WebElement heroImageLogo;

    @FindBy(css = "section.FavoriteShowsCarousel")
    public WebElement favoriteShowsCarousel;

    @FindBy(css = "section.FavoriteShowsCarousel h3 div")
    public WebElement favoriteShowsTitle;


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

    public WebElement getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(WebElement heroImage) {
        this.heroImage = heroImage;
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

    public WebElement getHeroImagePlusIcon() {
        return heroImagePlusIcon;
    }

    public void setHeroImagePlusIcon(WebElement heroImagePlusIcon) {
        this.heroImagePlusIcon = heroImagePlusIcon;
    }

    public WebElement getHeroImageMinusIcon() {
        return heroImageMinusIcon;
    }

    public void setHeroImageMinusIcon(WebElement heroImageMinusIcon) {
        this.heroImageMinusIcon = heroImageMinusIcon;
    }

    public WebElement getFavoriteShowsCarousel() {
        return favoriteShowsCarousel;
    }

    public void setFavoriteShowsCarousel(WebElement favoriteShowsCarousel) {
        this.favoriteShowsCarousel = favoriteShowsCarousel;
    }

    public WebElement getFavoriteShowsTitle() {
        return favoriteShowsTitle;
    }

    public void setFavoriteShowsTitle(WebElement favoriteShowsTitle) {
        this.favoriteShowsTitle = favoriteShowsTitle;
    }




}
