package com.example.workoutPlan.planner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONArray;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PlannerController {

    @Autowired
    private PlannerService plannerService;

    @GetMapping("/randomPlan")
    public WorkoutPlan getWorkout(){
        return plannerService.createPlan("placeholder");
    }

    @PostMapping("/generatePlan")
    public WorkoutPlan generatePlan(@RequestBody WorkoutPlan workoutPlan){
        plannerService.generatePlan(workoutPlan);
        System.out.println("Post mapping done");
        return workoutPlan;
    }


}
