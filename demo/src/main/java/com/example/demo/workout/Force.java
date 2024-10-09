package com.example.demo.workout;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Force {
    STATIC("static"),
    PULL("pull"),
    PUSH("push");

    private final String value;

    Force(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Force fromValue(String value) {
        for (Force force : Force.values()) {
            if (force.value.equalsIgnoreCase(value)) {
                return force;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
