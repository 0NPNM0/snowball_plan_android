package com.example.snowball_plan.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.snowball_plan.entity.DayPlan;

import java.util.ArrayList;
import java.util.List;

public class DayPlanDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "dayplan.db";
    private static final String TABLE_DAY = "day_plan";
    private static final int DB_VERSION = 1;
    private static DayPlanDBHelper dbHelper = null;
    private SQLiteDatabase mRDB = null;
    private SQLiteDatabase mWDB = null;

    public DayPlanDBHelper(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    //用单例模式获取数据库帮助器的唯一实例
    public static DayPlanDBHelper getInstance(Context context){
        if(dbHelper == null){
            dbHelper = new DayPlanDBHelper(context);
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


    public DayPlanDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //创建日任务表
        String sql = "CREATE TABLE IF NOT EXISTS "+ TABLE_DAY +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " date VARCHAR NOT NULL,"+
                "start_time VARCHAR NOT NULL,"+
                "end_time VARCHAR NOT NULL,"+
                "type VARCHAR NOT NULL,"+
                "list VARCHAR NOT NULL,"+
                "color INTEGER NOT NULL);";

//                "repeat VARCHAR ,"+
//                "conflictp VARCHAR ,"+
//                "overtime VARCHAR NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //保存日计划
    public long save(DayPlan dayPlan){
        ContentValues cv = new ContentValues();
//        cv.put("id",dayPlan.id);
        cv.put("date",dayPlan.date);
        cv.put("start_time",dayPlan.start_time);
        cv.put("end_time",dayPlan.end_time);
        cv.put("type",dayPlan.type);
        cv.put("list",dayPlan.list);
        cv.put("color",dayPlan.color);

//        cv.put("repeat",dayPlan.repeat);
//        cv.put("conflictp",dayPlan.conflictp);
//        cv.put("overtime",dayPlan.overtime);

        return mWDB.insert(TABLE_DAY,null,cv);
    }

    public long deletePlan(int id){
         return mWDB.delete(TABLE_DAY,"_id=?",new String[]{String.valueOf(id)});
    }

//    public int queryPlanById(int id) {
//
//        return id;
//    }

    public long updatePlan(int id){
        ContentValues values = new ContentValues();
//
//        mRDB.query(TABLE_DAY,new String[]{String.valueOf(id)},)
//
//        values.put("date",dayPlan.date);
//        values.put("start_time",dayPlan.start_time);
//        values.put("end_time",dayPlan.end_time);
//        values.put("type",dayPlan.type);
//        values.put("list",dayPlan.list);
//        values.put("color",dayPlan.color);
        return mWDB.update(TABLE_DAY,values,"id=?",new String[]{String.valueOf(id)});
    }


    @SuppressLint("Range")
    public List<DayPlan> queryByMonth(String yearMonth){
        List<DayPlan> list = new ArrayList<>();

        //select * from day_plan where date like '2035_09%'
        String sql = "select * from " + TABLE_DAY + " where date like '"+yearMonth+"%'";
        Log.d("ning",sql);
        Cursor cursor = mRDB.rawQuery(sql,null);
        while(cursor.moveToNext()){
            DayPlan plan = new DayPlan();
            plan.id = cursor.getInt(cursor.getColumnIndex("_id"));
            plan.date = cursor.getString(cursor.getColumnIndex("date"));
            plan.start_time = cursor.getString(cursor.getColumnIndex("start_time"));
            plan.end_time = cursor.getString(cursor.getColumnIndex("end_time"));
            plan.type = cursor.getString(cursor.getColumnIndex("type"));
            plan.list = cursor.getString(cursor.getColumnIndex("list"));
            plan.color = cursor.getInt(cursor.getColumnIndex("color"));

            list.add(plan);
        }

        return list;
    }

}
