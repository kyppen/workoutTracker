package com.example.demo.workout;

import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Exercise {
    private String id;
    private String name;
    private Force force; // Nullable
    private Level level;
    private Mechanic mechanic; // Nullable
    private Equipment equipment; // Nullable
    private List<Muscle> primaryMuscles;
    private List<Muscle> secondaryMuscles;
    private List<String> instructions;
    private Category category;
    private List<String> images;

    // Constructors
    public Exercise() {
    }

    public Exercise(String id, String name, Force force, Level level, Mechanic mechanic,
                    Equipment equipment, List<Muscle> primaryMuscles, List<Muscle> secondaryMuscles,
                    List<String> instructions, Category category, List<String> images) {
        this.id = id;
        this.name = name;
        this.force = force;
        this.level = level;
        this.mechanic = mechanic;
        this.equipment = equipment;
        this.primaryMuscles = primaryMuscles;
        this.secondaryMuscles = secondaryMuscles;
        this.instructions = instructions;
        this.category = category;
        this.images = images;
    }
    
    @Override
    public String toString() {
        return "Exercise{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", force=" + force +
                ", level=" + level +
                ", mechanic=" + mechanic +
                ", equipment=" + equipment +
                ", primaryMuscles=" + primaryMuscles +
                ", secondaryMuscles=" + secondaryMuscles +
                ", instructions=" + instructions +
                ", category=" + category +
                ", images=" + images +
                '}';
    }
}