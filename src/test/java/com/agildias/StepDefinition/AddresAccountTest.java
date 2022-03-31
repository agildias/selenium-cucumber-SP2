package com.agildias.StepDefinition;

import com.agildias.pageObject.AddresMyAccountPage;
import com.agildias.pageObject.LoginPage;
import com.agildias.pageObject.MyAccountPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddresAccountTest {
    private WebDriver webDriver;

    public AddresAccountTest() {
        super();
        this.webDriver = Hook.webDriver;
    }
    @Given("User login and go to My Account address")
    public void navigateToAddressAccount() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.navigateToLoginPage();
        loginPage.inputEmail("agil@mailnesia.com");
        loginPage.inputPassword("d1234567");
        loginPage.clickLogin();
        MyAccountPage myAccountPage=new MyAccountPage(webDriver);
        myAccountPage.accountUser();
        myAccountPage.btnAccounts();
        Thread.sleep(2000);

    }
    @When("User input all fill\"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"")
    public void inputFillAddresPage(String firstName,String lastName,String company,String address,String address2,String zip,String city,String home,String mobile,String add,String ref) throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage(webDriver);
        myAccountPage.btnAddressAccount();
        AddresMyAccountPage addres = new AddresMyAccountPage(webDriver);
        addres.inputFirstName(firstName);
        addres.inputLastName(lastName);
        addres.inputCompany(company);
        addres.inputAddress(address);
        addres.inputAddress2(address2);
        addres.inputPostalCode(zip);
        addres.inputCity(city);
        addres.selectState();
        addres.selectCountry();
        addres.inputHompePhone(home);
        addres.inputMobilePhone(mobile);
        addres.inputAdditional(add);
        addres.inputFutureReference(ref);
        addres.clickBtnSave();
    }
    @Then("user get error notification")
    public void notificationErrorMessage() throws InterruptedException {
        AddresMyAccountPage addres = new AddresMyAccountPage(webDriver);
        Assert.assertTrue(addres.errorNotif());
    }
    @Then("mobile assertEqual")
    public void assertMobile() throws InterruptedException {
        AddresMyAccountPage addres = new AddresMyAccountPage(webDriver);
        String actualMobile  = addres.isActualMobile();
        String expectedMobile= addres.isExpectedMobile();
        Assert.assertEquals(expectedMobile,actualMobile);
    }
    @When("User click my addres")
    public void myPersonalAddress(){
        AddresMyAccountPage addres = new AddresMyAccountPage(webDriver);
        addres.btnMyaddress();
    }
    @Then("User delete data addres")
    public void deleteDataAddress() throws InterruptedException {
        AddresMyAccountPage addres = new AddresMyAccountPage(webDriver);
        addres.clickDelete();
    }
}
