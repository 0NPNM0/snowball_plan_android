package com.example.snowball_plan.entity;

public class DayPlan {

    public int id;
    public String date;
    public String start_time;
    public String end_time;
    public String type;
    public String list;
    public int color;

//    public String repeat;
//    public String conflictp;
//    public String overtime;


    public DayPlan() {
    }

    public DayPlan(int id, String date, String start_time, String end_time, String type, String list, int color) {
        this.id = id;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.type = type;
        this.list = list;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "DayPlan{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", type='" + type + '\'' +
                ", list='" + list + '\'' +
                ", color=" + color +
                '}';
    }
}
