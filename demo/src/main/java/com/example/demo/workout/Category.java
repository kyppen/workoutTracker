package com.example.demo.workout;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
    POWERLIFTING("powerlifting"),
    STRENGTH("strength"),
    STRETCHING("stretching"),
    CARDIO("cardio"),
    OLYMPIC_WEIGHTLIFTING("olympic weightlifting"),
    STRONGMAN("strongman"),
    PLYOMETRICS("plyometrics");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Category fromValue(String value) {
        for (Category category : Category.values()) {
            if (category.value.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
