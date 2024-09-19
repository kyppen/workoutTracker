package com.example.demo.workout;


import com.example.demo.Product.Product;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;

    @GetMapping("/workout")
    public JSONArray getWorkout(){
        return workoutService.generateWorkout();
    }
    @GetMapping("/actuator/healthcheck")
    public String healthCheck(){
        return "200";
    }

}
