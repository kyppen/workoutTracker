package com.example.Validator.Validating;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class ValidatorController {
    @Autowired
    private ValidatorService validatorService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/validateplan")
    public WorkoutPlan validatePlan(@RequestBody WorkoutPlan workoutPlan){
        System.out.println("ValidatePlan()");
        validatorService.sendMessage(workoutPlan.toString());

        return workoutPlan;
    }
    @GetMapping("/send")
    public String sendMessage() {
        //Setup for MQ, takes http://localhost:8085/send get request and adds it to queue
        validatorService.sendMessage("message");
        return "Message sent!";
    }
}
