package com.agildias.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderHotelPage {
    private static WebDriver driver;

    public OrderHotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//div[@id='category_data_cont']/div[1]//a[.='Book Now']")
    private WebElement orderGeneral;

    @FindBy(xpath = "//span[@id='layer_cart_product_time_duration']")
    private WebElement timeDuration;

    @FindBy(xpath = "//a[contains(.,'Proceed to checkout')]")
    private WebElement procedToCheckOut;

    @FindBy(xpath = "//p[@class='cart_final_total_block']/span[@class='cart_total_values']")
    private WebElement expectedPriceRoom;

    @FindBy(xpath = "//div[@class='total_price_block']//span[@class='room_type_current_price']")
    private WebElement actualPriceRoom;

    public void bookGeneralRoom(){
        orderGeneral.click();
    }
    public String expectedTimeDuration(){
        String expected = "17-03-2022 - 18-03-2022";
        System.out.println("expected : "+expected);
        return expected;
    }
    public String actualTimeDuration(){
        driver.switchTo().activeElement();
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOf(timeDuration));
        timeDuration.getText();
        System.out.println("actual : "+timeDuration.getText());
        return timeDuration.getText();
    }
    public void clickCheckOutOrder(){
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOf(timeDuration));
        procedToCheckOut.click();
    }
    public String expectedPrice(){
        System.out.println("expected : "+ expectedPriceRoom.getText());
       return expectedPriceRoom.getText();
    }
    public String actualPrice(){
        System.out.println("actual : "+ actualPriceRoom.getText());
        return actualPriceRoom.getText();
    }
}
