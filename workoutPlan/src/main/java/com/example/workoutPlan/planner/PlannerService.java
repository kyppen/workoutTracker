package com.example.workoutPlan.planner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.jdbc.Work;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PlannerService {

    private final RestTemplate restTemplate;
    private final RestTemplateConfig restTemplateConfig;


    public PlannerService(RestTemplate restTemplate, RestTemplateConfig restTemplateConfig) {
        this.restTemplate = restTemplate;
        this.restTemplateConfig = restTemplateConfig;
    }


    public List<exercise> getWorkoutData(){
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("getWorkoutData()");
        String url = "http://localhost:8082/workout";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String jsonString = response.getBody();
        System.out.println(jsonString);
        try{
            List<exercise> foo = objectMapper.readValue(jsonString, new TypeReference<List<exercise>>(){});
            foo.forEach(System.out::println);
            return foo;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public WorkoutPlan createPlan(String placeholdername){
        //WorkoutPlan workoutPlan = new WorkoutPlan("1", "name", getWorkoutData());
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setWorkoutName("Placeholder");
        workoutPlan.setWorkoutPlanId("2");
        workoutPlan.setExercises(getWorkoutData());
        return workoutPlan;
    }

    public WorkoutPlan generatePlan(WorkoutPlan workoutPlan){
        System.out.println("plannerservice");

        return workoutPlan;
    }

}