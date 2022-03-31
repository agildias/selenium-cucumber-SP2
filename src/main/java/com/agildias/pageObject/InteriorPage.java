package com.agildias.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InteriorPage {
    private static WebDriver driver;

    public InteriorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "hotelInteriorBlock")
    private WebElement titleInterior;

    @FindBy(xpath = "//div[4]/div[@class='interiorImgWrapper']/div[1]")
    private WebElement picInterior;

    @FindBy(className = "fancybox-image")
    private WebElement imageDisplay;

    @FindBy(xpath = "//a[@class='fancybox-item fancybox-close']")
    private WebElement closeBtn;

    @FindBy(xpath = "//i[@class='icon-angle-right']")
    private WebElement btnSlideImageRight;

    @FindBy(xpath = "//i[@class='icon-angle-left']")
    private WebElement btnSlideImageLeft;

    public boolean getTextTitle() {
        String title = titleInterior.getText();
        System.out.println(title);
        return title.equals(titleInterior);
    }

    public void getPicInterior() {
        picInterior.click();
    }

    public boolean isImageDisplayed() {
        imageDisplay.isDisplayed();
        System.out.println("Image : " + imageDisplay.isDisplayed());
        return true;
    }

    public void closeImg() {
        closeBtn.click();
    }

    public void btnLeftImage() {
        btnSlideImageLeft.click();
    }

    public void btnRightImage() {
        btnSlideImageRight.click();
    }
}

