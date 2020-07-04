package com.webapp.enums;

import com.webapp.helper.exceptions.LoggedException;

public enum UserType {
    ST("standard user", "standard user", "standard"),
    LO("locked out user", "locked out user", "LockedOut"),
    PB("problem user" , "problem user", "problemUser"),
    PG("performance glitch user" , "performance glitch user", "performaceGlitch");

    private final String name;
    private final String shortName;

    UserType(String userType, String name, String shortName) {
        this.name = name;
        this.shortName =  shortName;
    }

    public static UserType getShortName(String name) {
        for (UserType thisUserType : UserType.values()) {
            if (thisUserType.getName().equalsIgnoreCase(name)) {
                return thisUserType;
            }
        }
        throw new LoggedException("UserType " + name + " not found");
    }

    public String getName() {
        return name;
    }
    public String getShortName() {
        return shortName;
    }
}

