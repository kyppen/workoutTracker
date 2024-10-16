package com.example.demo.workout;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import java.io.File;
import java.sql.Time;
import java.util.List;
import java.util.Random;



@Service
public class WorkoutService {

    public JSONArray generateWorkout(){
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray jsonArray = new JSONArray();

        try{
            File jsonFile = new File("src/main/java/exercises.json");
            //System.out.println(jsonFile.isFile());
            List<Exercise> exercises = objectMapper.readValue(jsonFile, new TypeReference<List<Exercise>>() {});
            Random random = new Random();

            for(int i = 0; i < 8; i++){
                int index = random.nextInt(872 + 1);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("sets", 4);
                jsonObject.put("weight", 30);
                jsonObject.put("exerciseId", index);
                jsonArray.add(jsonObject);
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(jsonArray);
        return jsonArray;
    }

    public Exercise getWorkoutById(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File jsonFile = new File("src/main/java/exercises.json");
            //System.out.println(jsonFile.isFile());
            List<Exercise> exercises = objectMapper.readValue(jsonFile, new TypeReference<List<Exercise>>() {});
            for(Exercise e : exercises){
                System.out.println(e.toString());
            }
            return exercises.get(id);


        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }
}
