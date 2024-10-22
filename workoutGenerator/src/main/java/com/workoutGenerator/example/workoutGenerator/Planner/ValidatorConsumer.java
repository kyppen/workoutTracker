package com.workoutGenerator.example.workoutGenerator.Planner;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class ValidatorConsumer {
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            WorkoutPlan workoutPlan = objectMapper.readValue(message, WorkoutPlan.class);
            Generator generator = new Generator();
            generator.generateWorkout(workoutPlan);
            System.out.println(workoutPlan.toString());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to map object");
        }
    }
}
