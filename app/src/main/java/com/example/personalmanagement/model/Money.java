package com.example.personalmanagement.model;

public class Money {
    private int id;
    private String title;
    private String date;
    private String time;
    private double amount;
    private String describe;

    public Money() {
    }

    public Money(int id, String title, String date, String time, double amount, String describe) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.time = time;
        this.amount = amount;
        this.describe = describe;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
