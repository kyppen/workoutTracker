package com.example.demo.workout;


import com.example.demo.Product.Product;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;

    @GetMapping("/workout")
    public JSONArray getWorkout(){
        return workoutService.generateWorkout();
    }


}
