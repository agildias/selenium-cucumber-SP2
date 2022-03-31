package com.agildias.StepDefinition;

import com.agildias.pageObject.BookingHotelPage;
import com.agildias.pageObject.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BookHotelTest {
    private WebDriver webDriver;

    public BookHotelTest() {
        super();
        this.webDriver = Hook.webDriver;
    }
    @Given("User login \"(.*)\" \"(.*)\" and go to dashboard")
    public void userLogin(String user, String pwd){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.navigateToLoginPage();
        loginPage.inputEmail(user);
        loginPage.inputPassword(pwd);
        loginPage.clickLogin();
        loginPage.clickBtnLogo();
    }
    @When("User searh the hotel book")
    public void searchBookingHotel() throws InterruptedException {
        BookingHotelPage bookHotel = new BookingHotelPage(webDriver);
        bookHotel.searchLocationHotel();
        bookHotel.searchNameHotel();
        bookHotel.checkInDate();
        bookHotel.checkOutDate();
        bookHotel.buttonSearchNow();
    }
    @Then("User verify date Book Hotel")
    public void verifyDateHotel(){
        BookingHotelPage bookHotel = new BookingHotelPage(webDriver);
        Assert.assertEquals(bookHotel.expectedCheckIn(),bookHotel.actualCheckIn());
        Assert.assertEquals(bookHotel.expectedCheckOut(),bookHotel.actualCheckOut());
    }
    @Then("User verify Location of Hotel")
    public void verifyLocationHotel() throws InterruptedException {
        BookingHotelPage bookHotel = new BookingHotelPage(webDriver);
        Assert.assertEquals(bookHotel.expectedLocation(),bookHotel.actualLocation());
    }
    @When("User input check in \"(.*)\" and checkout date \"(.*)\"")
    public void inputDateToBookHotel(String inDate,String outDate) throws InterruptedException {
        BookingHotelPage bookHotel = new BookingHotelPage(webDriver);
        bookHotel.searchLocationHotel();
        bookHotel.searchNameHotel();
        bookHotel.inputCheckInDate(inDate);
        bookHotel.inputCheckOutDate(outDate);
    }
    @Then("user click button search now")
    public void clickButtonSearchNow(){
        BookingHotelPage bookHotel = new BookingHotelPage(webDriver);
        bookHotel.buttonSearchNow();
    }
}
