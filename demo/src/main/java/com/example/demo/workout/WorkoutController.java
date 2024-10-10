package com.example.demo.workout;


import com.example.demo.Product.Product;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;

    @GetMapping("/workout")
    public JSONArray getWorkout(){
        return workoutService.generateWorkout();
    }
    @GetMapping("/workout/{id}")
    public Exercise getWorkoutById(@PathVariable int id){
        return workoutService.generateWorkoutbyId(id);
    }


}
