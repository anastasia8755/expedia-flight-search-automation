package com.expedia.pages;

import com.expedia.pages.components.SearchPanelComponent;
import org.openqa.selenium.WebDriver;
public class ExpediaFlightsPage extends BasePage {

    private SearchPanelComponent searchPanel;

    public ExpediaFlightsPage(WebDriver driver) {
        super(driver);
        this.searchPanel = new SearchPanelComponent(driver, "#flight_search_form");
    }

    public SearchPanelComponent getSearchPanel() {
        return searchPanel;
    }
}