package io.zipcoder.utilities;

public enum BillStatus {

    PENDING("Pending"),
    CANCELLED("Cancelled"),
    COMPLETED("Completed"),
    RECURRING("Recurring");

    private String status;

    BillStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return status;
    }

    public void setValue(String status) {
        this.status = status;
    }
}
