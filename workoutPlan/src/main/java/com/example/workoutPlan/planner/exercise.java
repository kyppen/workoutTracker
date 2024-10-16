package com.example.workoutPlan.planner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class exercise {
    private String exerciseId;
    private int sets;
    private double weight;

}