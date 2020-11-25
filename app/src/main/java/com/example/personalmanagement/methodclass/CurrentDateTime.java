package com.example.personalmanagement.methodclass;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrentDateTime {
    public static String getCurrentDate() {
        String date = "";
        String time="";
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("dd/MM/yyyy");
        calendar.set(year, month, day);
        date += simpleDateFormat.format( calendar.getTime());
        return date;
    }
    public static String getCurrentTime() {
        String time="";
        Calendar calendar = Calendar.getInstance();
        int hour= calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) SimpleDateFormat.getTimeInstance();
//        simpleDateFormat.applyPattern("HH:mm");
//        calendar.set(hour,minute);
        time += simpleDateFormat.format( calendar.getTime());
        return time;
    }
}
