package com.agildias.StepDefinition;

import com.agildias.pageObject.InteriorPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class InteriorTest {
    private WebDriver webDriver;

    public InteriorTest(){
        super();
        this.webDriver = Hook.webDriver;
    }
    @Given("User read the title of Interior Page")
    public void pictureInterior() throws InterruptedException {
        InteriorPage interiorPage = new InteriorPage(webDriver);
        interiorPage.getTextTitle();

    }
    @When("User Click slide button")
    public void buttonSlideDisplayInterior(){
        InteriorPage interiorPage= new InteriorPage(webDriver);
        interiorPage.btnLeftImage();
        interiorPage.btnRightImage();
    }
    @And("user click image interior until displayed")
    public void imageDisplayInterior(){
        InteriorPage interiorPage= new InteriorPage(webDriver);
        interiorPage.getPicInterior();
        Assert.assertTrue(interiorPage.isImageDisplayed());
    }
    @Then("User Close The Image picture")
    public void closeImageDisplayInterior() throws InterruptedException {
        InteriorPage interiorPage= new InteriorPage(webDriver);
        Thread.sleep(2000);
        interiorPage.closeImg();
    }
}
