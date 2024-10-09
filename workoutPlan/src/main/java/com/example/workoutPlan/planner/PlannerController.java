package com.example.workoutPlan.planner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONArray;

@RestController
public class PlannerController {

    @Autowired
    private PlannerService plannerService;

    @GetMapping("/plan")
    public JSONArray getWorkout(){


        return plannerService.GenerateQueue();

    }


}
