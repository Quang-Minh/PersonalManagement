package com.example.personalmanagement.model;

import java.util.List;

public class Fitness {
    private int id;
    private String date;
    private int exerciseId;
    private String describe;

    public Fitness() {
    }

    public Fitness(int id, String date, int exerciseId, String describe) {
        this.id = id;
        this.date = date;
        this.exerciseId = exerciseId;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
