package com.agildias.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//span[@class='hide_xs']")
    private WebElement navigateLogin;

    @FindBy(id = "header_logo")
    private WebElement title;

    @FindBy(id = "email")
    private WebElement userName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement btnLogin;

    @FindBy(xpath = "//ol/li")
    private WebElement errorMsg;

    @FindBy(id = "header_logo")
    private WebElement btnLogo;

    public void navigateToLoginPage(){
        navigateLogin.click();
    }
    public boolean schoolTitle() {
        String title = driver.getTitle();
        System.out.println(title);
        return true;
    }
    public void inputEmail(String user){
        userName.sendKeys(user);
    }

    public void inputPassword(String pwd){
        password.sendKeys(pwd);
    }

    public void clickLogin(){
        btnLogin.click();
    }
    public String getErrorMessage(){
        return errorMsg.getText();
    }

    public void clickBtnLogo(){
        btnLogo.click();
    }
}
