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


    public WebElement getFavoriteShowsHeading() {
        return favoriteShowsHeading;
    }

    public void setFavoriteShowsHeading(WebElement favoriteShowsHeading) {
        this.favoriteShowsHeading = favoriteShowsHeading;
    }

    public WebElement getFavoriteShowsCarouselContent() {
        return favoriteShowsCarouselContent;
    }

    public void setFavoriteShowsCarouselContent(WebElement favoriteShowsCarouselContent) {
        this.favoriteShowsCarouselContent = favoriteShowsCarouselContent;
    }

    @FindBy(css = "section.FavoriteShowsCarousel div.carousel__content")
    WebElement favoriteShowsCarouselContent;

    @FindBy(css = "section.FavoriteShowsCarousel h2")
    WebElement favoriteShowsHeading;

    public List<WebElement> getMyVideosFavoriteShowsImage() {
        return myVideosFavoriteShowsImage;
    }

    public void setMyVideosFavoriteShowsImage(List<WebElement> myVideosFavoriteShowsImage) {
        this.myVideosFavoriteShowsImage = myVideosFavoriteShowsImage;
    }

    @FindBy(css = "section.FavoriteShowsCarousel div.image-box")
    List<WebElement> myVideosFavoriteShowsImage;

    public List<WebElement> getMyVideosContentBox() {
        return myVideosContentBox;
    }

    public void setMyVideosContentBox(List<WebElement> myVideosContentBox) {
        this.myVideosContentBox = myVideosContentBox;
    }

    @FindBy(css = "section.FavoriteShowsCarousel div.carousel-tile-wrapper")
    List<WebElement> myVideosContentBox;


    public WebElement getMyVideosFavoriteShowsTitle() {
        return myVideosFavoriteShowsTitle;
    }

    public void setMyVideosFavoriteShowsTitle(WebElement myVideosFavoriteShowsTitle) {
        this.myVideosFavoriteShowsTitle = myVideosFavoriteShowsTitle;
    }

    @FindBy(css = "section.FavoriteShowsCarousel div.content-box h3 div")
    WebElement myVideosFavoriteShowsTitle;

    @FindBy(css = "section.FavoriteShowsCarousel")
    public WebElement favoriteShowsCarousel;

    public WebElement getFavoriteShowsCarousel() {
        return favoriteShowsCarousel;
    }

    public void setFavoriteShowsCarousel(WebElement favoriteShowsCarousel) {
        this.favoriteShowsCarousel = favoriteShowsCarousel;
    }

}
