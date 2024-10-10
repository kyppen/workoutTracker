package com.example.workoutPlan.planner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlannerService {

    private final RestTemplate restTemplate;

    public PlannerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<exercise> getWorkoutData(){
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("getWorkoutData()");
        String url = "http://localhost:8082/workout";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String jsonString = response.getBody();
        try{
            List<exercise> foo = objectMapper.readValue(jsonString, new TypeReference<List<exercise>>(){});
            foo.forEach(System.out::println);
            return foo;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
    public WorkoutPlan createPlan(String workoutName){
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setWorkoutName(workoutName);
        workoutPlan.setWorkoutPlanId("1");
        workoutPlan.setExercises(getWorkoutData());

        return workoutPlan;
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