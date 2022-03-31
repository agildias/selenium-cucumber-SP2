package com.agildias.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private static WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(className = "info-account")
    private WebElement titlePage;

    @FindBy(id = "user_info_acc")
    private WebElement userAccount;

    @FindBy(xpath = "//a[.='Accounts']")
    private WebElement account;

    @FindBy(xpath = "//span[.='Add my first address']")
    private WebElement btnFirstAddres;

    public boolean textDisplay(){
        titlePage.isDisplayed();
        String txt = titlePage.getText();
        System.out.println(txt);
        return true;
    }
    public void accountUser(){
        userAccount.click();
    }
    public void btnAccounts(){
        account.click();
    }
    public void btnAddressAccount(){
        btnFirstAddres.click();
    }
}
