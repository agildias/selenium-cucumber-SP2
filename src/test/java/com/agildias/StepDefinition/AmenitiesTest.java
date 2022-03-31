package com.agildias.StepDefinition;

import com.agildias.pageObject.AmenitiesPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AmenitiesTest {
    private WebDriver webDriver;

    public AmenitiesTest(){
        super();
        this.webDriver = Hook.webDriver;
    }
    @Given("User read title and description of Amenities")
    public void titleAndDescription(){
        AmenitiesPage amenitiesPage = new AmenitiesPage(webDriver);
        amenitiesPage.setTitleAmenities();

    }
    @When("User see all image in amenities")
    public void imageInAmenities(){
        AmenitiesPage amenitiesPage = new AmenitiesPage(webDriver);
        amenitiesPage.listImageAmenitiesDisplay();
        Assert.assertTrue(amenitiesPage.listImageAmenitiesDisplay());
    }
    @Then("User read all facility description")
    public void facilityInAmenities(){
        AmenitiesPage amenitiesPage = new AmenitiesPage(webDriver);
        amenitiesPage.facilityAmenities();
        Assert.assertTrue(amenitiesPage.facilityAmenities());
    }
}
