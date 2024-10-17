package com.expedia.pages;

import com.expedia.pages.components.FilterPanelComponent;
import com.expedia.pages.components.FlyInformationComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ExpediaFlightsSearchPage extends BasePage {

    private final FilterPanelComponent filterPanel;

    public ExpediaFlightsSearchPage(WebDriver driver) {
        super(driver);
        waitUntilPageLoaded();
        this.filterPanel = new FilterPanelComponent(driver, "div[data-test-id='filter-container']");
    }

    private void waitUntilPageLoaded() {
        waitForElementToBeVisible(driver.findElement(By.cssSelector("div[data-stid='standard-offer-card-viewability']")));
    }

    public FilterPanelComponent getFilterPanel() {
        return filterPanel;
    }

    public List<FlyInformationComponent> getFlyCards() {
        List<FlyInformationComponent> flyCards = new ArrayList<>();
        waitUntilPageLoaded();
        driver.findElements(By.cssSelector("div[data-stid='standard-offer-card-viewability']"))
                .forEach(element -> flyCards.add(new FlyInformationComponent(driver, element)));
        return flyCards;
    }
}
