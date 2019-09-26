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
public class DiscoveryMyVideosPage extends DriverScript {

    WebDriver driver;

    public DiscoveryMyVideosPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "section.FavoriteShowsCarousel div.carousel__content")
    private WebElement favoriteShowsCarouselContent;

    @FindBy(css = "section.FavoriteShowsCarousel h2")
    private WebElement favoriteShowsHeading;

    @FindBy(css = "section.FavoriteShowsCarousel div.content-box h3 div")
    private WebElement myVideosFavoriteShowsTitle;

    @FindBy(css = "section.FavoriteShowsCarousel")
    private WebElement favoriteShowsCarousel;

    @FindBy(css = "section.FavoriteShowsCarousel div.image-box")
    private List<WebElement> myVideosFavoriteShowsImage;

    @FindBy(css = "section.FavoriteShowsCarousel div.carousel-tile-wrapper")
    private List<WebElement> myVideosContentBox;

    public WebElement getFavoriteShowsHeading() {
        return favoriteShowsHeading;
    }

    public WebElement getFavoriteShowsCarouselContent() {
        return favoriteShowsCarouselContent;
    }

    public List<WebElement> getMyVideosFavoriteShowsImage() {
        return myVideosFavoriteShowsImage;
    }

    public List<WebElement> getMyVideosContentBox() {
        return myVideosContentBox;
    }

    public WebElement getMyVideosFavoriteShowsTitle() {
        return myVideosFavoriteShowsTitle;
    }

    public WebElement getFavoriteShowsCarousel() {
        return favoriteShowsCarousel;
    }


}
