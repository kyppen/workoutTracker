package com.example.demo.workout;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Mechanic {
    ISOLATION("isolation"),
    COMPOUND("compound");

    private final String value;

    Mechanic(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Mechanic fromValue(String value) {
        if (value == null) {
            return null; // Handle nullable cases
        }
        for (Mechanic mechanic : Mechanic.values()) {
            if (mechanic.value.equalsIgnoreCase(value)) {
                return mechanic;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
