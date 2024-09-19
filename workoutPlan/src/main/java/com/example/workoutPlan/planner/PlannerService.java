package com.example.workoutPlan.planner;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONArray;

@Service
public class PlannerService {

    private final RestTemplate restTemplate;

    public PlannerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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