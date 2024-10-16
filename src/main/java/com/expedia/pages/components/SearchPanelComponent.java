package com.expedia.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPanelComponent extends BaseComponent {

    private WebElement departureAirportButton;
    private WebElement arrivalAirportButton;
    private WebElement roomPicker;
    private WebElement searchButton;

    @FindBy(css = "div.uitk-input-swapper-start-input input#origin_select")
    private WebElement departureAirport;

    @FindBy(css = "div.uitk-input-swapper-end-input input#destination_select")
    private WebElement arrivalAirport;

    @FindBy(css = "[data-stid='EGDSDateRangePicker-StartDate']")
    private WebElement startDay;

    @FindBy(css = "[data-stid='EGDSDateRangePicker-EndDate']")
    private WebElement endDay;

    public SearchPanelComponent(WebDriver driver, String baseLocator) {
        super(driver, baseLocator);
        this.departureAirportButton = baseElement.findElement(By.cssSelector("div.uitk-input-swapper-start-input [data-stid='origin_select-menu-trigger']"));
        this.arrivalAirportButton = baseElement.findElement(By.cssSelector("div.uitk-input-swapper-end-input [data-stid='destination_select-menu-trigger']"));
        this.roomPicker = baseElement.findElement(By.cssSelector("button[data-stid='open-room-picker']"));
        this.searchButton = baseElement.findElement(By.id("search_button"));
    }

    public SearchPanelComponent setDepartureAirport(String value) {
        departureAirportButton.click();
        departureAirport.clear();
        departureAirport.sendKeys(value);
        departureAirport.sendKeys(Keys.ENTER);
        return this;
    }

    public SearchPanelComponent setArrivalAirport(String value) {
        arrivalAirportButton.click();
        arrivalAirport.clear();
        arrivalAirport.sendKeys(value);
        arrivalAirport.sendKeys(Keys.ENTER);
        return this;
    }

    public SearchPanelComponent setStartDate(String value) {
        executeJavaScript("arguments[0].value = arguments[1];", startDay, value);
        return this;
    }

    public SearchPanelComponent setEndDate(String value) {
        executeJavaScript("arguments[0].value = arguments[1];", endDay, value);
        return this;
    }

    public SearchPanelComponent setTravelers(int adults, int children, int infantsOnLap, int infantsInSeat) {
        roomPicker.click();

        setTravelerCount("traveler_selector_adult_step_input", adults);
        setTravelerCount("traveler_selector_children_step_input", children);
        setTravelerCount("traveler_selector_infants_on_lap_step_input", infantsOnLap);
        setTravelerCount("traveler_selector_infants_in_seat_step_input", infantsInSeat);

        driver.findElement(By.id("travelers_selector_done_button")).click();

        return this;
    }

    private void setTravelerCount(String inputId, int count) {
        WebElement inputField = driver.findElement(By.id(inputId));
        WebElement decreaseButton = inputField.findElement(By.xpath("preceding-sibling::button[1]"));
        WebElement increaseButton = inputField.findElement(By.xpath("following-sibling::button[1]"));

        while (Integer.parseInt(inputField.getAttribute("value")) > count) {
            decreaseButton.click();
        }

        while (Integer.parseInt(inputField.getAttribute("value")) < count) {
            increaseButton.click();
        }
    }

    public void clickSearchButton(){
        searchButton.click();
    }
}
