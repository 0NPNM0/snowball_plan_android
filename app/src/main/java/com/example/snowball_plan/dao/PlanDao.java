package com.example.snowball_plan.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.snowball_plan.entity.DayPlan;

import java.util.List;

@Dao
public interface PlanDao {

    @Insert
    void insert(DayPlan dayPlan);

    @Delete
    void delete(DayPlan dayPlan);

    @Update
    int update(DayPlan dayPlan);

    @Query("SELECT * FROM DayPlan")
    List<DayPlan> queryAll ();

    @Query("SELECT * FROM DayPlan WHERE id = :id")
    DayPlan queryById(int id);
}
