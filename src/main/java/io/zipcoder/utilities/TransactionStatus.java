package io.zipcoder.utilities;

public enum TransactionStatus {

    PENDING("Pending"),
    CANCELLED("Cancelled"),
    COMPLETED("Completed");

    private String status;

    TransactionStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return status;
    }

    public void setValue(String status) {
        this.status = status;
    }
}
