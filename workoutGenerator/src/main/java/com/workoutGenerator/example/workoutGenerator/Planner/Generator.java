package com.workoutGenerator.example.workoutGenerator.Planner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Generator {
    public void generateWorkout(WorkoutPlan workoutPlan){
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray jsonArray = new JSONArray();
        List<Exercise> adding = new ArrayList<>();

        try{
            File jsonFile = new File("workoutGenerator/src/main/java/exercises.json");
            System.out.println(jsonFile.isFile());
            List<Exercise> exercises = objectMapper.readValue(jsonFile, new TypeReference<List<Exercise>>() {});
            Random random = new Random();
            for(int i = 0; i < workoutPlan.getAmount(); i++){
                for(int j = 0; j < exercises.size(); j++){
                    Exercise e = exercises.get(random.nextInt(exercises.size()));
                    if(Objects.equals(e.getCategory(), workoutPlan.getCategory())){
                        if(checkingEquipment(workoutPlan, e.getEquipment())){
                            workoutPlan.addExercise(e);
                            break;
                        };
                        //System.out.println("Adding");
                    }else{
                        //System.out.println(e.getCategory() + " ||| " + workoutPlan.getCategory() );
                        //System.out.println("no match");
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(jsonArray);
    }

    public boolean checkingEquipment(WorkoutPlan workoutplan, String input ){
        System.out.println(workoutplan.getEquipments());
        List<String> comparing = workoutplan.getEquipments();
        if (comparing != null) {
            for (String s : comparing) {
                if (input.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
