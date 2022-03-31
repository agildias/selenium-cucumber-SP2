package com.agildias.StepDefinition;

import com.agildias.pageObject.OurRoomPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class OurRoomsTest {
    private WebDriver webDriver;

    public OurRoomsTest(){
        super();
        this.webDriver = Hook.webDriver;
    }
    @Given("User read title and description of OurRooms page")
    public void titleOfOurRooms(){
        OurRoomPage roomPage = new OurRoomPage(webDriver);
        roomPage.setTitleOurRooms();
        Assert.assertTrue(roomPage.setTitleOurRooms());
    }
    @When("User Check list Rooms page")
    public void listProductOurRooms() throws InterruptedException {
        OurRoomPage roomPage = new OurRoomPage(webDriver);
        roomPage.setListOurRooms();
    }
    @Then("User Click Book Now and Back to homepage our rooms")
    public void clickBtnBookNow() throws InterruptedException {
        OurRoomPage roomPage = new OurRoomPage(webDriver);
        roomPage.setBtnBookNow();
    }
}
