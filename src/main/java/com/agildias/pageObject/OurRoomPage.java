package com.agildias.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OurRoomPage {
    private static WebDriver driver;

    public OurRoomPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='hotelRoomsBlock']//div[@class='col-md-offset-1 col-md-10 col-lg-offset-2 col-lg-8']")
    private WebElement titleOurRooms;

    @FindBy(className = "hotelRoomDescContainer")
    private List<WebElement> listOurRooms;

    @FindBy(xpath = "//span[.='book now']")
    private List<WebElement> btnBookNow;


    public boolean setTitleOurRooms(){
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(titleOurRooms).build().perform();
        String room =titleOurRooms.getText();
        System.out.println(room);
        return true;
    }
    public void setListOurRooms() throws InterruptedException {
        listOurRooms.size();
        for (int i = 0; i <listOurRooms.size(); i++) {
            String productlist = listOurRooms.get(i).getText();
            Thread.sleep(2000);
            System.out.println("Product list : "+productlist);
        }

    }
    public void setBtnBookNow() throws InterruptedException {
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(titleOurRooms).build().perform();
        for (int i = 0; i <listOurRooms.size(); i++) {
            String productlist = listOurRooms.get(i).getText();
            Thread.sleep(2000);
            btnBookNow.get(i).click();
        }
        String base = driver.getWindowHandle();

        driver.switchTo().window(base);

    }
}
