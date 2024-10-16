package com.expedia.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Helper {
    public static String getDatePlusDays(int n) {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(n);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return futureDate.format(formatter);
    }

    public static String getTodayDate() {
        return getDatePlusDays(0);
    }
}
