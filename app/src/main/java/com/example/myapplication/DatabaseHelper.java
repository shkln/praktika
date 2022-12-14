package com.example.myapplication;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_PRICE = "my expenses"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "expenses"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID= "ID";
    public static final String COLUMN_PRICE = "Price";
    public static final String COLUMN_PLACE= "Place";
    public static final String COLUMN_CATEGORY = "Category";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_PRICE, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+ TABLE +
                "(" + COLUMN_ID  + " integer PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PLACE + " TEXT, "
                + COLUMN_CATEGORY + " TEXT, "
                + COLUMN_PRICE +" real);");
        // добавление начальных данных
      db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_PRICE
              + ", " + COLUMN_PLACE + ") VALUES (368.9, 'ТРЦ Ашан');");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}