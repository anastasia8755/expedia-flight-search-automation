package com.expedia.constants;

public enum Filters {
    NON_STOP("Nonstop");

    private final String value;

    Filters(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
