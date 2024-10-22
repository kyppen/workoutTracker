package com.workoutGenerator.example.workoutGenerator.Planner;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@ToString
public class WorkoutPlan {
    @Getter
    @Setter
    private String username;
    private String workoutName;
    private Integer amount;
    private String category;
    private List<String> equipments;
    private List<Exercise> exercises = new ArrayList<>();


    public void addExercise(Exercise e){
        System.out.println("add exercise");
        exercises.add(e);
    }
}
