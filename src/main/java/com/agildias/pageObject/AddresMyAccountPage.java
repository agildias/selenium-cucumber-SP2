package com.agildias.pageObject;

import gherkin.lexer.Th;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddresMyAccountPage {
    private static WebDriver driver;

    public AddresMyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//span[.='Add my first address']")
    private WebElement btnFirstAddres;

    @FindBy(id = "firstname")
    private WebElement firtname;

    @FindBy(id = "lastname")
    private WebElement lastname;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "vat-number")
    private WebElement vatNumber;

    @FindBy(id = "address1")
    private WebElement firstAddress;

    @FindBy(id = "address2")
    private WebElement secondAddress;

    @FindBy(id = "postcode")
    private WebElement postalcode;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "phone")
    private WebElement homePhone;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "other")
    private WebElement additionalInformation;

    @FindBy(id = "alias")
    private WebElement titleForFuture;

    @FindBy(id ="submitAddress")
    private WebElement btnSave;

    @FindBy(xpath = "//ol/li")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[@class='address_phone_mobile']")
    private WebElement addresMobile;

    @FindBy(xpath = "//a[.='Delete']")
    private WebElement btnDelete;

    @FindBy(xpath = "//a[.='My addresses']")
    private WebElement myAddresses;

    public void inputFirstName(String firstName){
        firtname.sendKeys(firstName);
    }
    public void inputLastName(String lastName){
        lastname.sendKeys(lastName);
    }
    public void inputCompany(String userCompany){
        company.sendKeys(userCompany);
    }
    public void inputAddress(String addres){
        firstAddress.sendKeys(addres);
    }
    public void inputAddress2(String addres2){
        secondAddress.sendKeys(addres2);
    }
    public void inputPostalCode(String zip){
        postalcode.sendKeys(zip);
    }
    public void inputCity(String userCity){
        city.sendKeys(userCity);
    }
    public void selectState() throws InterruptedException {
        Thread.sleep(2000);
        Select selectState = new Select(state);
        selectState.selectByValue("322");
    }
    public void selectCountry(){
        Select selectCountry = new Select(country);
        selectCountry.selectByValue("111");
    }
    public void inputHompePhone(String userHomePhone){
        homePhone.sendKeys(userHomePhone);
    }
    public void inputMobilePhone(String userMobilePhone){
        mobilePhone.sendKeys(userMobilePhone);
    }
    public void inputAdditional(String additi){
        additionalInformation.sendKeys(additi);
    }
    public void inputFutureReference(String reference){
        titleForFuture.sendKeys(reference);
    }
    public void clickBtnSave(){
        btnSave.click();
    }
    public boolean errorNotif() throws InterruptedException {
        errorMessage.isDisplayed();
        String errortxt = errorMessage.getText();
        System.out.println(errortxt);
        Thread.sleep(2000);
        return errorMessage.isDisplayed();
    }
    public String isActualMobile(){
     return addresMobile.getText();
    }
    public String isExpectedMobile(){
        String expected = "085666999777";
        return expected;
    }
    public void btnMyaddress(){
        myAddresses.click();
    }
    public void clickDelete() throws InterruptedException {
        Thread.sleep(2000);
        btnDelete.click();
        driver.switchTo().alert().accept();
    }
}
