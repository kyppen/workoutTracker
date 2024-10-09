package com.example.demo.Queue;

import com.example.demo.workout.WorkoutController;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void listen(String message) {
        System.out.println("Listener");
        System.out.println("Received Message: " + message);


    }
}