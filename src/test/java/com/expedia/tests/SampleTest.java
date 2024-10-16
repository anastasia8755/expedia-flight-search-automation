package com.expedia.tests;

import com.expedia.constants.Airports;
import com.expedia.pages.ExpediaFlightsPage;
import com.expedia.pages.HomePage;
import com.expedia.utils.Helper;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(driver);
        homePage.login("testuser", "testpassword");

    }

    @Test
    public void flyTest() {
        ExpediaFlightsPage flyPage = new ExpediaFlightsPage(driver);

        flyPage.getSearchPanel()
                .setDepartureAirport(Airports.MCO.getValue())
                .setArrivalAirport(Airports.JFK.getValue())
                .setStartDate(Helper.getDatePlusDays(10))
                .setEndDate(Helper.getDatePlusDays(15))
                .setTravelers(2, 0, 0, 0)
                .clickSearchButton();

        System.out.println();

    }
}
