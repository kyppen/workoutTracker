package com.example.workoutPlan.planner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class WorkoutPlan {
    private String username;
    private String workoutPlanId;
    private String workoutName;
    private String category;
    private List<exercise> exercises;
    private List<String> equipments;

}
