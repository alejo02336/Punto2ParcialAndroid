package com.example.problemtwo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "hemo.db";
    public static final String TABLE_PERSONAS = "t_personas";



    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PERSONAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL,"+
                "apellido TEXT NOT NULL,"+
                "hemoglobina TEXT NOT NULL,"+
                "edad TEXT NOT NULL,"+
                "correo TEXT NOT NULL,"+
                "sexo TEXT NOT NULL,"+
                "estado TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PERSONAS);
        onCreate(sqLiteDatabase);
    }
}
