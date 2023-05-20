package com.example.snowball_plan.entity;

public class DayPlan {

    public String start_time;
    public String end_time;
    public String type;
    public String list;
    public String repeat;
    public String conflictp;
    public String color;
    public String overtime;

    public DayPlan(String start_time, String end_time, String type, String list, String repeat, String conflictp, String color, String overtime) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.type = type;
        this.list = list;
        this.repeat = repeat;
        this.conflictp = conflictp;
        this.color = color;
        this.overtime = overtime;
    }

    public DayPlan() {
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

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getConflict() {
        return conflictp;
    }

    public void setConflict(String conflictp) {
        this.conflictp = conflictp;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    @Override
    public String toString() {
        return "DayPlan{" +
                "start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", type='" + type + '\'' +
                ", list='" + list + '\'' +
                ", repeat='" + repeat + '\'' +
                ", conflictp='" + conflictp + '\'' +
                ", color='" + color + '\'' +
                ", overtime='" + overtime + '\'' +
                '}';
    }
}
