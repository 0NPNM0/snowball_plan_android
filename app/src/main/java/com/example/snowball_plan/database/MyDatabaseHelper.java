package com.example.snowball_plan.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context mcontext;

    public static final String CREATE_TASK = "create table task ("
        +"task_id integer primary key autoincrement unique not null,"
        +"task_type_id integer unique not null,"
        +"task_list_id integer unique not null,"
        +"task_color_id integer unique not null,"
        +"task_image_id integer unique,"
        +"task_overtime_tick text unique not null,"
        +"task_repeat_date text,"
        +"task_conflict_plan text)";

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TASK);
        Toast.makeText(mcontext, "create task succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
