package com.example.demo.workout;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
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
            File jsonFile = new File("demo/src/main/java/exercises.json");
            System.out.println(jsonFile.isFile());
            List<Exercise> exercises = objectMapper.readValue(jsonFile, new TypeReference<List<Exercise>>() {});
            Random random = new Random();

            for(int i = 0; i < 1; i++){
                int index = random.nextInt(872 + 1);
                jsonArray.add(exercises.get(index));
            }


        }catch (Exception e){
            e.printStackTrace();
        }


        return jsonArray;
    }

}
