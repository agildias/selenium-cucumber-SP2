package com.agildias.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
    private static WebDriver driver;

    public MenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//button[@class='nav_toggle']")
    private WebElement menuBtn;

    @FindBy(xpath = "//a[.='Home']")
    private WebElement homeBtn;

    @FindBy(xpath = "//h1[@class='header-hotel-name']")
    private WebElement displayTextHome;

    @FindBy(xpath = "//a[.='Interior']")
    private WebElement interiorBtn;

    @FindBy(xpath = "//p[.='Interior']")
    private WebElement displayTextInterior;

    @FindBy(xpath = "//a[.='Amenities']")
    private WebElement amenitiesBtn;

    @FindBy(xpath = "//p[.='Amenities']")
    private WebElement displayAmenities;


    public void buttonMenu(){
        menuBtn.click();
    }
    public void btnHome(){
        homeBtn.click();
    }
    public boolean isDisplayHome(){
        displayTextHome.isDisplayed();
        System.out.println(displayTextHome.getText());
        return true;
    }
    public void btnInterior(){
        interiorBtn.click();
    }
    public boolean isDisplayInterior(){
        displayTextInterior.isDisplayed();
        System.out.println(displayTextInterior.getText());
        return true;
    }
    public void btnAmenities(){
        amenitiesBtn.click();
    }
    public boolean isDisplayAmenities(){
        displayAmenities.isDisplayed();
        System.out.println(displayAmenities.getText());
        return true;
    }

}
