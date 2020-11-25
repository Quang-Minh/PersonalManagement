package com.example.personalmanagement.model;

public class Meal {
    private int id;
    private String title;
    private String date;
    private String time;
    private String detailMeal;

    public Meal() {
    }

    public Meal(int id, String title, String date, String time, String detailMeal) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.time = time;
        this.detailMeal = detailMeal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetailMeal() {
        return detailMeal;
    }

    public void setDetailMeal(String detailMeal) {
        this.detailMeal = detailMeal;
    }
}
