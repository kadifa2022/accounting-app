package com.accounting.enums;

public enum CompanyStatus {



    ACTIVE("Active"), PASSIVE("Passive");

    CompanyStatus(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
