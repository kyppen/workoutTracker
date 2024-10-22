package com.example.Validator.Validating;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        ObjectMapper objectMapper = new ObjectMapper();
        validatorService.sendMessage(workoutPlan);

        return workoutPlan;
    }
    @GetMapping("/send")
    public String sendMessage() {
        //Setup for MQ, takes http://localhost:8085/send get request and adds it to queue
        validatorService.sendMessage2("message");
        return "Message sent!";
    }
}
