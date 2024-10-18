package com.workoutGenerator.example.workoutGenerator.Planner;


import lombok.Getter;
import lombok.Setter;

import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Exercise {
    private String id;
    private String name;
    private String force;
    private String level;
    private String mechanic;
    private String equipment;
    private List<String> primaryMuscles;
    private List<String> secondaryMuscles;
    private List<String> instructions;
    private String category;
    private List<String> images;
}