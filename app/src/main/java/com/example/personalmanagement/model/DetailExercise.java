package com.example.personalmanagement.model;

public class DetailExercise {
    private int id;
    private int fitnessId;
    private int exerciseId;
    private String describe;

    public DetailExercise() {
    }

    public DetailExercise(int id, int fitnessId, int exerciseId, String describe) {
        this.id = id;
        this.fitnessId = fitnessId;
        this.exerciseId = exerciseId;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFitnessId() {
        return fitnessId;
    }

    public void setFitnessId(int fitnessId) {
        this.fitnessId = fitnessId;
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
