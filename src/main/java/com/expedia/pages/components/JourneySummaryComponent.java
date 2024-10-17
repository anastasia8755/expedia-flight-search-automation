package com.expedia.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JourneySummaryComponent extends BaseComponent{

    @FindBy(css = "div[data-test-id='flight-review-header'] > div > h2")
    private List<WebElement> airportsLabels;
    @FindBy(css = "div[data-test-id='flight-review-header'] > div:last-child div.uitk-text")
    private List<WebElement> flightDates;

    private final String forwardDepartureAirport;
    private final String forwardArrivalAirport;
    private final String backDepartureAirport;
    private final String backArrivalAirport;

    private final String startDate;
    private final String endDate;


    public JourneySummaryComponent(WebDriver driver, String baseLocator) {
        super(driver, baseLocator);
        String[] forwardAirports = airportsLabels.get(0).getText().split(" to ");
        String[] backAirports = airportsLabels.get(1).getText().split(" to ");
        forwardDepartureAirport = forwardAirports[0];
        forwardArrivalAirport = forwardAirports[1];
        backDepartureAirport = backAirports[0];
        backArrivalAirport = backAirports[1];

        startDate = flightDates.get(0).getText().split(" • ")[1];
        endDate = flightDates.get(1).getText().split(" • ")[1];
    }

    public String getForwardDepartureAirport() {
        return forwardDepartureAirport;
    }

    public String getForwardArrivalAirport() {
        return forwardArrivalAirport;
    }

    public String getBackDepartureAirport() {
        return backDepartureAirport;
    }

    public String getBackArrivalAirport() {
        return backArrivalAirport;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
