package com.agildias.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookingHotelPage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public BookingHotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(id = "hotel_location")
    private WebElement locationHotel;

    @FindBy(xpath = "//li[.='Indonesia']")
    private WebElement indo;

    @FindBy(id = "id_hotel_button")
    private WebElement nameHotel;

    @FindBy(xpath = "//li[@class='search_result_li']")
    private WebElement primeHotel;

    @FindBy(xpath = "//a[.='Next']")
    private WebElement nextMonth;

    @FindBy(id = "check_in_time")
    private WebElement checkInTime;

    @FindBy(id = "check_out_time")
    private WebElement checkOutTime;

    @FindBy(id = "search_room_submit")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='hotel_location']")
    private WebElement actualLocationHotel;

    @FindBy(id = "check_in_time")
    private WebElement actualCheckInTime;

    @FindBy(id = "check_out_time")
    private WebElement actualCheckOutTime;

    public void searchLocationHotel() throws InterruptedException {
        locationHotel.sendKeys("Indonesia");
        Thread.sleep(2000);
        indo.click();
        System.out.println("Expected Location : " + locationHotel.getAttribute("value"));
    }


    public void searchNameHotel(){
        nameHotel.click();
        primeHotel.click();
        nameHotel.getText();
        System.out.println(nameHotel.getText());
    }
    public void checkInDate(){
        checkInTime.click();
        nextMonth.click();
        WebElement dateWidget = driver.findElement(By.className("ui-datepicker-calendar"));
        List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
        for (WebElement cell: columns) {
            if (cell.getText().equals("19")) {
                cell.findElement(By.linkText("19")).click();
                break;
            }
        }
        String v = checkInTime.getAttribute("value");
        System.out.println("Date : "+v);
    }
    public void checkOutDate(){
        checkOutTime.click();
        WebElement dateWidget = driver.findElement(By.className("ui-datepicker-calendar"));
        List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
        for (WebElement cell: columns) {
            if (cell.getText().equals("21")) {
                cell.findElement(By.linkText("21")).click();
                break;
            }
        }
        String x = checkOutTime.getAttribute("value");
        System.out.println("Date : "+x);
    }
    public void buttonSearchNow(){
        searchButton.click();
    }
    public String expectedCheckIn(){
        String expectedDate = checkInTime.getAttribute("value");
        System.out.println("Expected CheckIn  : "+expectedDate);
        return expectedDate;
    }
    public String expectedCheckOut() {
        String expectedDate = checkOutTime.getAttribute("value");
        System.out.println("Expected CheckOut : " + expectedDate);
        return expectedDate;
    }
    public Object expectedLocation(){
        String expectedLoc = "Indonesia";
        System.out.println("Expected Location : "+expectedLoc);
        return expectedLoc;
    }
    public String actualCheckIn(){
        String actualDate = actualCheckInTime.getAttribute("value");
        System.out.println("Actual CheckIn    : " +actualDate);
        return actualDate;
    }
    public String actualCheckOut(){
        String actualDate = actualCheckOutTime.getAttribute("value");
        System.out.println("Actual CheckOut   : " +actualDate);
        return actualDate;
    }
    public String actualLocation(){
        String actualLoc = actualLocationHotel.getAttribute("value");
        System.out.println("Actual Location   : "+actualLoc);
        return actualLoc;
    }
    public void inputCheckInDate(String inDate){
        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        for (WebElement input : inputs) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].removeAttribute('readonly','readonly')", input);
        }
        checkInTime.sendKeys(inDate);
        System.out.println(checkInTime.getAttribute("value"));
    }
    public void inputCheckOutDate(String outDate){
        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        for (WebElement input : inputs) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].removeAttribute('readonly','readonly')", input);
        }
        checkOutTime.sendKeys(outDate);
        System.out.println(checkOutTime.getAttribute("value"));
    }
}
