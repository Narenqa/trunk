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
    private WebElement headerLogo;

    @FindBy(css = "li.dscHeaderMain__showsLink")
    private WebElement showsLink;

	@FindBy(css = "a.dscShowsDropContent__seeAllShows")
	private WebElement seeAllShowsButton;

    @FindBy(css = "div.allShowsGrid__container")
    private WebElement seeAllGrid;

    @FindBy(xpath = "//div/a[contains(@href,\"apollo\")]")
    private WebElement tvShowsTitle;


    @FindBy(css = "div.showHero__showImage")
    private WebElement heroImage;

    @FindBy(css = "div.showHero__main i.icon-plus")
    private WebElement heroImagePlusIcon;

    @FindBy(css = "div.showHero__main i.icon-minus")
    private WebElement heroImageMinusIcon;

    @FindBy(css = "img.showHero__showLogo")
    private WebElement heroImageLogo;

    @FindBy(css = "section.FavoriteShowsCarousel")
    private WebElement favoriteShowsCarousel;

    @FindBy(css = "section.FavoriteShowsCarousel h3 div")
    private WebElement favoriteShowsTitle;

    @FindBy(css = "li>svg.dscHeaderMain__iconMenu")
    private WebElement menuIcon;

    @FindBy(css = "a[href=\"/my-videos\"]")
    private WebElement myVidesLink;

    public WebElement getHeroImageLogo() {
        return heroImageLogo;
    }


    public WebElement getMyVidesLink() {
        return myVidesLink;
    }

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

    public WebElement getHeroImage() {
        return heroImage;
    }

    public WebElement getTvShowsTitle() {
        return tvShowsTitle;
    }

    public WebElement getHeroImagePlusIcon() {
        return heroImagePlusIcon;
    }

    public WebElement getHeroImageMinusIcon() {
        return heroImageMinusIcon;
    }

    public WebElement getFavoriteShowsCarousel() {
        return favoriteShowsCarousel;
    }

    public WebElement getFavoriteShowsTitle() {
        return favoriteShowsTitle;
    }

}
