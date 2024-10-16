package com.expedia.constants;

public enum Airports {
    MCO("Orlando, FL (MCO-Orlando Intl.)"),
    JFK("New York, NY (JFK-John F. Kennedy Intl.)");

    private final String value;

    Airports(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
