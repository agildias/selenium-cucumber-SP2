package com.agildias.StepDefinition;

import com.agildias.pageObject.BookingHotelPage;
import com.agildias.pageObject.OrderHotelPage;
import com.sun.org.apache.xpath.internal.operations.Or;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class OrderHotelTest {
    private WebDriver webDriver;

    public OrderHotelTest() {
        super();
        this.webDriver = Hook.webDriver;
    }
    @Given("User check in \"(.*)\" and checkout date \"(.*)\"")
    public void searchBookingHotel(String inDate,String outDate) throws InterruptedException {
        BookingHotelPage bookHotel = new BookingHotelPage(webDriver);
        bookHotel.searchLocationHotel();
        bookHotel.searchNameHotel();
        bookHotel.inputCheckInDate(inDate);
        bookHotel.inputCheckOutDate(outDate);
        bookHotel.buttonSearchNow();
    }
    @When("User order General Rooms Hotel")
    public void orderGeneralRoom(){
        OrderHotelPage orderHotel = new OrderHotelPage(webDriver);
        orderHotel.bookGeneralRoom();
    }
    @Then("verify Time Duration Order")
    public void verifyOrder(){
        OrderHotelPage orderHotel = new OrderHotelPage(webDriver);
        Assert.assertEquals(orderHotel.expectedTimeDuration(),orderHotel.actualTimeDuration());
    }
    @Then("User proced to Checkut order")
    public void chekckOutOrder(){
        OrderHotelPage orderHotel = new OrderHotelPage(webDriver);
        orderHotel.clickCheckOutOrder();
    }
    @Then("User verify price")
    public void verifyPriceHotel(){
        OrderHotelPage orderHotel = new OrderHotelPage(webDriver);
        orderHotel.clickCheckOutOrder();
        Assert.assertEquals(orderHotel.expectedPrice(),orderHotel.actualPrice());
    }
}
