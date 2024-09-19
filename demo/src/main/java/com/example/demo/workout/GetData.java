package com.example.demo.workout;

import org.json.simple.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GetData{

    public String GenerateWorkout(){
        try{
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/exercises.json")));

            JSONObject jsonObject = new JSONObject();

        }catch (Exception e){
            e.printStackTrace();
        }
        return "hello";
    }

}
