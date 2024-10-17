package com.expedia.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlyInformationComponent extends BaseComponent{

    private final WebElement button;

    private final String departureAirport;
    private final String arrivalAirport;

    public FlyInformationComponent(WebDriver driver, WebElement baseElement) {
        super(driver, baseElement);
        button = baseElement.findElement(By.cssSelector("button[data-test-id='select-link']"));
        String[] arrivalDeparture = baseElement.findElement(By.cssSelector("div[data-test-id='arrival-departure']"))
                .getText().split(" - ");
        departureAirport = arrivalDeparture[0];
        arrivalAirport = arrivalDeparture[1];
    }

    public FlyDetailsAndFaresComponent click() {
        button.click();

        return new FlyDetailsAndFaresComponent(driver, "div[data-stid='flights-journey-available-fares']");
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }
}
