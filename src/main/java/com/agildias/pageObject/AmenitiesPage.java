package com.agildias.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmenitiesPage {
    private static WebDriver driver;

    public AmenitiesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-12 home_amenities_wrapper']//div[@class='col-md-offset-1 col-md-10 col-lg-offset-2 col-lg-8']")
    private WebElement titleAmenities;

    @FindBy(xpath = "//div[@class='col-md-6 padding-lr-0']")
    private List<WebElement> listImageAmenities;

    @FindBy(xpath = "//div[@class='amenity_desc_secondary']")
    private List<WebElement> allFacilityAmenities;


    public void setTitleAmenities(){
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(titleAmenities).build().perform();
        titleAmenities.getText();
        String title = titleAmenities.getText();
        System.out.println(title);
    }

    public boolean listImageAmenitiesDisplay(){
        listImageAmenities.get(0).isDisplayed();
        listImageAmenities.size();
        System.out.println(listImageAmenities.size());
        return true;
    }
    public boolean facilityAmenities(){
        allFacilityAmenities.size();
        allFacilityAmenities.get(0).isDisplayed();
        for (int i = 0; i <allFacilityAmenities.size(); i++) {
            String productname = allFacilityAmenities.get(i).getText();
            System.out.println(productname);
        }
        return true;
    }
}
