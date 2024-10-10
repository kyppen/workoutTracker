package com.example.workoutPlan.planner;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class WorkoutPlan {
    private String workoutPlanId;
    private String workoutName;
    private List<exercise> exercises;
}
