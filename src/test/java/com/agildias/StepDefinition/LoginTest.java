package com.agildias.StepDefinition;

import com.agildias.pageObject.LoginPage;
import com.agildias.pageObject.MyAccountPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginTest {
    private WebDriver webDriver;

    public LoginTest() {
        super();
        this.webDriver = Hook.webDriver;
    }
    @Given("User navigate to login home page")
    public void loginHomePage(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.navigateToLoginPage();
        loginPage.schoolTitle();
    }
    @When("User input \"(.*)\" as username and \"(.*)\" as password")
    public void invalidSignIn(String username, String pwd){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.inputEmail(username);
        loginPage.inputPassword(pwd);
        loginPage.clickLogin();
    }
    @Then("User get \"(.*)\"")
    public void errorNotification(String errorTxt){
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertEquals(errorTxt,loginPage.getErrorMessage());
    }
    @Then("User see dashboard")
    public void isLoginSucces(){
        MyAccountPage myAccountPage = new MyAccountPage(webDriver);
        Assert.assertTrue(myAccountPage.textDisplay());

    }
}
