package com.agildias.StepDefinition;

import com.agildias.pageObject.LoginPage;
import com.agildias.pageObject.PersonalInfoPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PersonalAccountTest {
    private WebDriver webDriver;

    public PersonalAccountTest() {
        super();
        this.webDriver = Hook.webDriver;
    }
    @Given("User Login \"(.*)\" \"(.*)\" and direct to MyAccount Page")
    public void loginToAccountPage(String user, String pwd){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.navigateToLoginPage();
        loginPage.inputEmail(user);
        loginPage.inputPassword(pwd);
        loginPage.clickLogin();
    }
    @When("User click personal information and input data \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"")
    public void infoAccount(String f,String l,String e,String p) throws InterruptedException {
        PersonalInfoPage profile = new PersonalInfoPage(webDriver);
        profile.personalInformation();
        profile.selectGender();
        profile.inputFirstName(f);
        profile.inputLastName(l);
        profile.inputEmail(e);
        profile.inputPassword(p);
        profile.btnSave();
    }
    @Then("User Get warn Notification \"(.*)\"")
    public void warnNotification(String msg){
        PersonalInfoPage profile = new PersonalInfoPage(webDriver);
        profile.errorTextDisplay(msg);
        Assert.assertTrue(profile.errorTextDisplay(msg));
    }
    @Then("User Get succes Notification \"(.*)\"")
    public void succesMessage(String scsMsg){
        PersonalInfoPage profile = new PersonalInfoPage(webDriver);
        profile.succesTextDisplay(scsMsg);
        Assert.assertTrue(profile.succesTextDisplay(scsMsg));
    }

}
