package com.expedia.pages;

import com.expedia.pages.components.JourneySummaryComponent;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final JourneySummaryComponent journeySummary;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        switchToNextTab();
        journeySummary = new JourneySummaryComponent(driver, "div[data-test-id='journey-summary']");
    }

    public JourneySummaryComponent getJourneySummary() {
        return journeySummary;
    }
}
