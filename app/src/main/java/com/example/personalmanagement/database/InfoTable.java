package com.example.personalmanagement.database;

import android.database.sqlite.SQLiteDatabase;

public class InfoTable {


    public InfoTable() {
    }

    public static final String TABLE_PLANS = "PLANS";
    public static final String COL_PLAN_ID = "PLAN_ID";
    public static final String COL_PLAN_NAME = "PLAN_NAME";
    public static final String COL_PLAN_DATE = "PLAN_DATE";
    public static final String COL_PLAN_TIME = "PLAN_TIME";
    public static final String COL_PLAN_DESCRIBE = "PLAN_DESCRIBE";

    public static final String TABLE_NOTES = "NOTES";
    public static final String COL_NOTE_ID = "NOTE_ID";
    public static final String COL_NOTE_TITLE = "NOTE_TITLE";
    public static final String COL_NOTE_DATE = "NOTE_DATE";
    public static final String COL_NOTE_TIME = "NOTE_TIME";
    public static final String COL_NOTE_CONTENT = "NOTE_CONTENT";
    public static final String COL_NOTE_ISDELETE = "IS_DELETE";


    public static final String TABLE_IMCOME = "INCOME";
    public static final String COL_INCOME_ID = "INCOME_ID";
    public static final String COL_INCOME_TITLE = "INCOME_TITLE";
    public static final String COL_INCOME_DATE = "INCOME_DATE";
    public static final String COL_INCOME_TIME = "INCOME_TIME";
    public static final String COL_INCOME_AMOUNT = "INCOME_AMOUNT";
    public static final String COL_INCOME_DESCRIBE = "INCOME_DESCRIBE";

    public static final String TABLE_EXPENSES = "EXPENSES";
    public static final String COL_EXPENSE_ID = "EXPENSE_ID";
    public static final String COL_EXPENSE_TITLE = "EXPENSE_TITLE";
    public static final String COL_EXPENSE_DATE = "EXPENSE_DATE";
    public static final String COL_EXPENSE_TIME = "EXPENSE_TIME";
    public static final String COL_EXPENSE_AMOUNT = "EXPENSE_AMOUNT";
    public static final String COL_EXPENSE_DESCRIBE = "EXPENSE_DESCRIBE";

    public static final String TABLE_EXERCISES = "EXERCISES";
    public static final String COL_EXERCISE_ID = "EXERCISE_ID";
    public static final String COL_EXERCISE_NAME = "EXERCISE_NAME";

    public static final String TABLE_FITNESS = "FITNESS";
    public static final String COL_FITNESS_ID = "FITNESS_ID";
    public static final String COL_FITNESS_DATE = "FITNESS_DATE";
    public static final String COL_FITNESS_EXERCISE_ID = "EXERCISE_ID";
    public static final String COL_FITNESS_DESCRIBE = "FITNESS_DESCRIBE";

    public static final String TABLE_MEALS = "MEALS";
    public static final String COL_MEAL_ID = "MEAL_ID";
    public static final String COL_MEAL_TITLE = "MEAL_TITLE";
    public static final String COL_MEAL_DATE = "MEAL_ID";
    public static final String COL_MEAL_TIME = "MEAL_ID";
    public static final String COL_MEAL_DETAIL = "MEAL_DETAIL";

    public static final String TABLE_ACCOUNT = "ACCOUNT";
    public static final String COL_ID = "ID";
    public static final String COL_EMAIL = "EMAIL";
    public static final String COL_PASSWORD = "PASSWORD";


    public static void createTablePlans(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_PLANS + "(" +
                COL_PLAN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                COL_PLAN_NAME + " NVARCHAR(100) NOT NULL," +
                COL_PLAN_DATE + " NCHAR(20) NOT NULL," +
                COL_PLAN_TIME + " NCHAR(20) NOT NULL," +
                COL_PLAN_DESCRIBE+ " TEXT NOT NULL" +
                ")";

        sqLiteDatabase.execSQL(createTable);
    }

    public static void createTableNotes(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NOTES + "(" +
                COL_NOTE_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                COL_NOTE_TITLE + " NVARCHAR(100) NOT NULL," +
                COL_NOTE_DATE + " NCHAR(20) NOT NULL," +
                COL_NOTE_TIME + " NCHAR(20) NOT NULL," +
                COL_NOTE_CONTENT+ " TEXT NOT NULL," +
                COL_NOTE_CONTENT+ " INTEGER NOT NULL" +
                ")";

        sqLiteDatabase.execSQL(createTable);
    }

    public static void createTableIncome(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_IMCOME + "(" +
                COL_INCOME_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                COL_INCOME_TITLE + " NVARCHAR(100) NOT NULL," +
                COL_INCOME_DATE + " NCHAR(20) NOT NULL," +
                COL_INCOME_TIME + " NCHAR(20) NOT NULL," +
                COL_INCOME_AMOUNT + " DOUBLE NOT NULL," +
                COL_INCOME_DESCRIBE + " TEXT NOT NULL" +
                ")";

        sqLiteDatabase.execSQL(createTable);
    }
    public static void createTableExpenses(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_EXPENSES + "(" +
                COL_EXPENSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                COL_EXPENSE_TITLE + " NVARCHAR(100) NOT NULL," +
                COL_EXPENSE_DATE + " NCHAR(20) NOT NULL," +
                COL_EXPENSE_TIME + " NCHAR(20) NOT NULL," +
                COL_EXPENSE_AMOUNT + " DOUBLE NOT NULL," +
                COL_EXPENSE_DESCRIBE + " TEXT NOT NULL" +
                ")";

        sqLiteDatabase.execSQL(createTable);
    }

    public static void createTableMeal(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_MEALS + "(" +
                COL_MEAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                COL_MEAL_TITLE + " NVARCHAR(100) NOT NULL," +
                COL_MEAL_DATE + " NCHAR(20) NOT NULL," +
                COL_MEAL_TIME + " NCHAR(20) NOT NULL," +
                COL_MEAL_DETAIL + " TEXT NOT NULL" +
                ")";

        sqLiteDatabase.execSQL(createTable);
    }

    public static void createTableFitness(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_FITNESS + "(" +
                COL_FITNESS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                COL_FITNESS_EXERCISE_ID + " INTEGER NOT NULL," +
                COL_FITNESS_DATE + " NCHAR(20) NOT NULL," +
                COL_FITNESS_DESCRIBE + " TEXT " +
                ")";

        sqLiteDatabase.execSQL(createTable);
    }

    public static void createTableExercises(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_EXERCISES + "(" +
                COL_EXERCISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                COL_EXERCISE_NAME + " NVARCHAR(100) NOT NULL" +
                ")";
        sqLiteDatabase.execSQL(createTable);
    }

    public static void createTableAccount(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_ACCOUNT + "(" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                COL_EMAIL + " NCHAR(100) NOT NULL," +
                COL_PASSWORD + " NCHAR(20) NOT NULL" +
                ")";
        sqLiteDatabase.execSQL(createTable);
    }
}
