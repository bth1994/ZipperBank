package io.zipcoder.utilities;

public enum Medium {

    BALANCE("Balance"),
    REWARDS("Rewards");

    private String value;

    Medium(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
