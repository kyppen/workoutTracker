package com.example.workoutPlan.planner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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


}
