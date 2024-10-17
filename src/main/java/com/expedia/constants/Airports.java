package com.expedia.constants;

public enum Airports {
    MCO("Orlando, FL (MCO-Orlando Intl.)", "Orlando (MCO)", "Orlando"),
    JFK("New York, NY (JFK-John F. Kennedy Intl.)", "New York (JFK)", "New York");

    private final String fullName;
    private final String shortName;
    private final String city;

    Airports(String fullName, String shortName, String city) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.city = city;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getCity() {
        return city;
    }
}
