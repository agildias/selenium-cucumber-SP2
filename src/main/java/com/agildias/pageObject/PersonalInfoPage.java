package com.agildias.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage {
    private static WebDriver driver;

    public PersonalInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//li/a[.='My personal information']")
    private WebElement btnPersonalInfo;

    @FindBy(id = "id_gender1")
    private WebElement radioBtn;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastname;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "old_passwd")
    private WebElement password;

    @FindBy(xpath = "//button[@name='submitIdentity']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//ol/li")
    private WebElement errorMessage;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement succesMessage;

    public void personalInformation() throws InterruptedException {
        Thread.sleep(1000);
        btnPersonalInfo.click();
    }
    public void selectGender(){
       radioBtn.click();
    }
    public void inputFirstName(String f){
        firstName.clear();
        firstName.sendKeys(f);
    }
    public void inputLastName(String l){
        lastname.clear();
        lastname.sendKeys(l);
    }
    public void inputEmail(String e){
        email.clear();
        email.sendKeys(e);
    }
    public void inputPassword(String p){
        password.sendKeys(p);
    }
    public void btnSave(){
        btnSubmit.click();
    }
    public boolean errorTextDisplay(String msg){
        errorMessage.isDisplayed();
        String eror = errorMessage.getText();
        System.out.println(eror);
        return true;
    }
    public boolean succesTextDisplay(String scsMsg){
        succesMessage.isDisplayed();
        String eror = succesMessage.getText();
        System.out.println(eror);
        return true;
    }
}
