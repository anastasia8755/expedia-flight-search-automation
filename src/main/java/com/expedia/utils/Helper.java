package com.expedia.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Helper {
    public static String getDatePlusDays(int n) {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(n);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return futureDate.format(formatter);
    }

    public static String getShortDate(String dateString) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, inputFormatter);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EEE, MMM d", Locale.ENGLISH);
        return date.format(outputFormatter);
    }
}
