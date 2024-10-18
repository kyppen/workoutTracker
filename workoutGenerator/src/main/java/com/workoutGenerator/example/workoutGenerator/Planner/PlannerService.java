package com.workoutGenerator.example.workoutGenerator.Planner;


import org.springframework.stereotype.Service;

@Service
public class PlannerService {

    public WorkoutPlan createPlan(WorkoutPlan workoutPlan){
        System.out.println("createPlan");
        Generator generator = new Generator();
        generator.generateWorkout(workoutPlan);
        return workoutPlan;
    }
}
