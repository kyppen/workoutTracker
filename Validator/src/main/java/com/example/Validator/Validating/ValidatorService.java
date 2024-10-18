package com.example.Validator.Validating;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {


    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ValidatorService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public WorkoutPlan validatePlan(WorkoutPlan workoutPlan){
        System.out.println("validatePlan()");


        return workoutPlan;
    }
    public void sendMessage2(WorkoutPlan workoutPlan) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, workoutPlan);
        System.out.println("Message sent: " + workoutPlan.toString());
    }
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
        System.out.println("Message sent: " + message);
    }
}
