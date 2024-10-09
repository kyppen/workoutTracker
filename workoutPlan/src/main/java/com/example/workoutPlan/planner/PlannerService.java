package com.example.workoutPlan.planner;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONArray;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

@Service
public class PlannerService {

    private final RestTemplate restTemplate;

    public PlannerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public JSONArray GenerateQueue(){
        final String QUEUE_NAME = "workoutgen";

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // 2. Declare a queue
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello, I would like a JSon File containing a workout regiment";

            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new JSONArray();
    }

    public JSONArray callOtherService(int amount) {
        String url = "http://localhost:8082/workout";

        JSONArray plan = new JSONArray();
        for(int i = 0; i < amount; i++) {
            JSONArray jsonArray = restTemplate.getForObject(url, JSONArray.class);
            //TODO add names to json files
            jsonArray.add(0, "workout: " + i);
            plan.add(jsonArray);
        }

        return plan;
    }


}