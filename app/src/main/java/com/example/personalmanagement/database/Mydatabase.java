package com.example.personalmanagement.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Mydatabase extends SQLiteOpenHelper {

    public Mydatabase(@Nullable Context context) {
        super(context, "smartdaily.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        InfoTable.createTablePlans(db);
        InfoTable.createTableNotes(db);
        InfoTable.createTableIncome(db);
        InfoTable.createTableExpenses(db);
        InfoTable.createTableMeal(db);
        InfoTable.createTableFitness(db);
        InfoTable.createTableExercises(db);
        InfoTable.createTableAccount(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
