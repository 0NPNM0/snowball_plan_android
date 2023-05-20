package com.example.snowball_plan.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.snowball_plan.entity.DayPlan;

public class DayDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "day.db";
    private static final String TABLE_DAY = "day_plan";
    private static final int DB_VERSION = 1;
    private static DayDBHelper dbHelper = null;
    private SQLiteDatabase mRDB = null;
    private SQLiteDatabase mWDB = null;

    public DayDBHelper(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    //用单例模式获取数据库帮助器的唯一实例
    public static DayDBHelper getInstance(Context context){
        if(dbHelper == null){
            dbHelper = new DayDBHelper(context);
        }
        return dbHelper;
    }

    //打开数据库的读连接
    public SQLiteDatabase openReadLink(){
        if(mRDB == null || !mRDB.isOpen()){
            mRDB = dbHelper.getReadableDatabase();
        }
        return mRDB;
    }

    //打开数据库的写连接
    public SQLiteDatabase openWriteLink(){
        if(mWDB == null || !mWDB.isOpen()){
            mWDB = dbHelper.getWritableDatabase();
        }
        return mWDB;
    }

    //关闭数据库连接
    public void closeLink(){
        if(mRDB != null && mRDB.isOpen()){
            mRDB.close();
            mRDB = null;
        }

        if(mWDB != null && mWDB.isOpen()){
            mWDB.close();
            mWDB = null;
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //创建日任务表
        String sql = "CREATE TABLE IF NOT EXISTS "+ TABLE_DAY +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "start_time VARCHAR NOT NULL,"+
                "end_time VARCHAR NOT NULL,"+
                "type VARCHAR NOT NULL,"+
                "list VARCHAR NOT NULL,"+
                "repeat VARCHAR ,"+
                "conflictp VARCHAR ,"+
                "color VARCHAR NOT NULL,"+
                "overtime VARCHAR NOT NULL);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //保存日计划
    public long save(DayPlan dayPlan){
        ContentValues cv = new ContentValues();
        cv.put("start_time",dayPlan.start_time);
        cv.put("end_time",dayPlan.end_time);
        cv.put("type",dayPlan.type);
        cv.put("list",dayPlan.type);
        cv.put("repeat",dayPlan.repeat);
        cv.put("conflictp",dayPlan.conflictp);
        cv.put("color",dayPlan.color);
        cv.put("overtime",dayPlan.overtime);

        return mWDB.insert(TABLE_DAY,null,cv);
    }
}
