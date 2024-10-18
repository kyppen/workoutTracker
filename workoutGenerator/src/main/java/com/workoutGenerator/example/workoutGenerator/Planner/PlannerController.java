package com.workoutGenerator.example.workoutGenerator.Planner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlannerController {

    @Autowired
    private PlannerService plannerService;

    @PostMapping("/generateplan")
    public WorkoutPlan generatePlan(@RequestBody WorkoutPlan workoutPlan){
        System.out.println("generatePlan()");
        plannerService.createPlan(workoutPlan);
        return workoutPlan;
    }
}
