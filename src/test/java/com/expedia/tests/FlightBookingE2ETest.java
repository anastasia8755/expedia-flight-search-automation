package com.expedia.tests;

import com.expedia.constants.Airports;
import com.expedia.constants.Filters;
import com.expedia.pages.ExpediaFlightsPage;
import com.expedia.pages.ExpediaFlightsSearchPage;
import com.expedia.pages.components.JourneySummaryComponent;
import com.expedia.utils.Helper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingE2ETest extends BaseTest {

    @Test
    public void flightBookingFlowTest() {
        String startDate = Helper.getDatePlusDays(10);
        String endDate = Helper.getDatePlusDays(15);

        ExpediaFlightsPage flyPage = new ExpediaFlightsPage(driver);

        flyPage.getSearchPanel()
                .setDepartureAirport(Airports.MCO.getFullName())
                .setArrivalAirport(Airports.JFK.getFullName())
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setTravelers(2, 0, 0, 0)
                .clickSearchButton()
                        .getFilterPanel()
                                .setFilter(Filters.NON_STOP.getValue(), true);

        ExpediaFlightsSearchPage flySearchPage = new ExpediaFlightsSearchPage(driver);

        Assert.assertFalse(flySearchPage.getFlyCards().isEmpty());
        flySearchPage
                .getFlyCards().forEach(card -> {
                    Assert.assertEquals(card.getDepartureAirport(), Airports.MCO.getShortName());
                    Assert.assertEquals(card.getArrivalAirport(), Airports.JFK.getShortName());
                });

        flySearchPage
                .getFlyCards().get(0)
                .click()
                .selectCheapestOption();

        JourneySummaryComponent journeySummary = flySearchPage
                .getFlyCards().get(0)
                .click()
                .selectCheapestOption()
                .clickNoThanks()
                .getJourneySummary();

        Assert.assertEquals(journeySummary.getForwardDepartureAirport(), Airports.MCO.getCity());
        Assert.assertEquals(journeySummary.getForwardArrivalAirport(), Airports.JFK.getCity());

        Assert.assertEquals(journeySummary.getBackDepartureAirport(), Airports.JFK.getCity());
        Assert.assertEquals(journeySummary.getBackArrivalAirport(), Airports.MCO.getCity());

        Assert.assertEquals(journeySummary.getStartDate(), Helper.getShortDate(startDate));
        Assert.assertEquals(journeySummary.getEndDate(), Helper.getShortDate(endDate));
    }
}
