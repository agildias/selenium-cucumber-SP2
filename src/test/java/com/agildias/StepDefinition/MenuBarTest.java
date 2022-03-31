package com.agildias.StepDefinition;

import com.agildias.pageObject.MenuPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MenuBarTest {
    private WebDriver webDriver;

    public MenuBarTest() {
        super();
        this.webDriver = Hook.webDriver;
    }
    @Given("User click Menu bar")
    public void clickMenuBar(){
        MenuPage menu = new MenuPage(webDriver);
        menu.buttonMenu();

    }
    @When("User Click Home button")
    public void clickButtonHome(){
        MenuPage menu = new MenuPage(webDriver);
        menu.btnHome();

    }
    @Then("User navigate to homepage")
    public void verifyHomePage(){
        MenuPage menu = new MenuPage(webDriver);
        menu.isDisplayHome();
        Assert.assertTrue(menu.isDisplayHome());
    }
    @When("User Click Interior button")
    public void clickButtonInterior(){
        MenuPage menu = new MenuPage(webDriver);
        menu.btnInterior();

    }
    @Then("User navigate to Interiorpage")
    public void verifyInteriorPage(){
        MenuPage menu = new MenuPage(webDriver);
        menu.isDisplayInterior();
        Assert.assertTrue(menu.isDisplayInterior());
    }
    @When("User Click Amenities button")
    public void clickButtonAmenities(){
        MenuPage menu = new MenuPage(webDriver);
        menu.btnAmenities();

    }
    @Then("User navigate to Amenitiespage")
    public void verifyAmenitiesPage(){
        MenuPage menu = new MenuPage(webDriver);
        menu.isDisplayAmenities();
        Assert.assertTrue(menu.isDisplayAmenities());
    }
}
