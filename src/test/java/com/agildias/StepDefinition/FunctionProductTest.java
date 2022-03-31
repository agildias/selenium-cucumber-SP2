package com.agildias.StepDefinition;

import com.agildias.pageObject.BookingHotelPage;
import com.agildias.pageObject.LoginPage;
import com.agildias.pageObject.ProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class FunctionProductTest {
    private WebDriver webDriver;

    public FunctionProductTest() {
        super();
        this.webDriver = Hook.webDriver;
    }

    @Given("User login \"(.*)\" \"(.*)\" and book")
    public void userLogin(String user, String pwd) {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.navigateToLoginPage();
        loginPage.inputEmail(user);
        loginPage.inputPassword(pwd);
        loginPage.clickLogin();
        loginPage.clickBtnLogo();
    }

    @And("User book and go to product page")
    public void searchBookingHotel() throws InterruptedException {
        BookingHotelPage bookHotel = new BookingHotelPage(webDriver);
        bookHotel.searchLocationHotel();
        bookHotel.searchNameHotel();
        bookHotel.checkInDate();
        bookHotel.checkOutDate();
        bookHotel.buttonSearchNow();
    }

    @When("User Check Function rating")
    public void productPageRatingFunction() {
        ProductPage productPage = new ProductPage(webDriver);
        productPage.guestRating();
    }

    @Then("User see product category")
    public void categoryDisplayed() {
        ProductPage productPage = new ProductPage(webDriver);
        productPage.isDisplayedData();
        Assert.assertTrue(productPage.isDisplayedData());
    }
    @When("User Check Amenities Function")
    public void productPageAmenitiesFunction(){
        ProductPage productPage = new ProductPage(webDriver);
        productPage.amenitiesFilter();
    }
    @Then("User see notification message \"(.*)\"")
    public void errorMessage(String textNotif) throws InterruptedException {
        ProductPage productPage = new ProductPage(webDriver);
        Thread.sleep(1000);
        Assert.assertTrue(textNotif,productPage.isDisplayedNotification());
    }
    @When("User Slide the price")
    public void slidePrice() throws InterruptedException {
        ProductPage productPage = new ProductPage(webDriver);
        productPage.sliderPrice();
    }
    @Then("User see product display")
    public void displatProduct(){
        ProductPage productPage = new ProductPage(webDriver);
        productPage.isDisplayedData();
        Assert.assertTrue(productPage.isDisplayedData());
    }

}
