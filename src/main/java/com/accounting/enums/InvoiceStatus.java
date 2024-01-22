package com.accounting.enums;

public enum InvoiceStatus {
    APPROVED("Approved"), AWAITING_APPROVAL("Awaiting Approval");

    private final String value;

    InvoiceStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
