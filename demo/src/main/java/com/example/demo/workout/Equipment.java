package com.example.demo.workout;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Equipment {
    MEDICINE_BALL("medicine ball"),
    DUMBBELL("dumbbell"),
    BODY_ONLY("body only"),
    BANDS("bands"),
    KETTLEBELLS("kettlebells"),
    FOAM_ROLL("foam roll"),
    CABLE("cable"),
    MACHINE("machine"),
    BARBELL("barbell"),
    EXERCISE_BALL("exercise ball"),
    EZ_CURL_BAR("e-z curl bar"),
    OTHER("other");

    private final String value;

    Equipment(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Equipment fromValue(String value) {
        if (value == null) {
            return null; // Handle nullable cases
        }
        for (Equipment equipment : Equipment.values()) {
            if (equipment.value.equalsIgnoreCase(value)) {
                return equipment;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}

