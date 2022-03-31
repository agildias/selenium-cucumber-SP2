package com.agildias.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductPage {
    private static WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(id = "category_data_cont")
    private WebElement categoryData;

    @FindBy(xpath = "//div[@class='noRoomsAvailAlert']")
    private WebElement messageNotif;

    @FindBy(xpath = "//div[@id='filter_price_silder']/a[1]")
    private WebElement slider;


    public void guestRating(){
        List<WebElement> checkBox = driver.findElements(By.cssSelector("[data-type='ratting']"));
            for (int i = 0 ; i < checkBox.size() ; i++){
                checkBox.get(i).click();
                String rating = checkBox.get(i).getAttribute("value");
                System.out.println("Star : " + rating);
            }

    }
    public void amenitiesFilter(){
        List<WebElement> checkBox = driver.findElements(By.cssSelector("[data-type='amenities']"));
        List<WebElement>    name  = driver.findElements(By.className("filters_name"));
        for (int i = 0 ; i < checkBox.size();i++){
            checkBox.get(i).click();
            String amenities = name.get(i).getText();
            System.out.println(amenities);
        }
    }
    public boolean isDisplayedData(){
        categoryData.isDisplayed();
        return true;
    }
    public boolean isDisplayedNotification(){
        messageNotif.isDisplayed();
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(messageNotif).build().perform();
        System.out.println(messageNotif.getText());
        return true;
    }
    public void sliderPrice() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(slider));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider,180,0).perform();
        Thread.sleep(2000);
    }


}
