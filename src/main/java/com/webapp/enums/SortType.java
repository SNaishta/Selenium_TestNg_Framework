package com.webapp.enums;

import com.webapp.helper.exceptions.LoggedException;

public enum SortType {

    AZ("A to Z", "A to Z", "AtoZ"),
    ZA("Z to A", "Z to A", "ZtoA"),
    lohi("low to high" , "low to high", "lohi"),
    hilo("high to low" , "high to low", "hilo");

    private final String sortType;
    private final String longName;

    SortType(String type, String longName, String sortType) {
        this.sortType = sortType;
        this.longName = longName;
    }

    public static SortType getSortCode(String type) {
        for (SortType thisSortType : SortType.values()) {
            if (thisSortType.getLongName().equalsIgnoreCase(type)) {
                return thisSortType;
            }
        }
        throw new LoggedException("UserType " + type + " not found");
    }

    public String getLongName() {
        return longName;
    }
    public String getSortType() {
        return sortType;
    }
}
