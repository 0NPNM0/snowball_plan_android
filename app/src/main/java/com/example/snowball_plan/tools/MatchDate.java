package com.example.snowball_plan.tools;

public class MatchDate {

    String date = null;
    int index = 0;

    public int matchDate(String date){
        if(date.equals("2023-5-26")) index = 0;
        if(date.equals("2023-5-27")) index = 1;
        if(date.equals("2023-5-28")) index = 2;
        if(date.equals("2023-5-29")) index = 3;
        if(date.equals("2023-5-30")) index = 4;
        if(date.equals("2023-5-31")) index = 5;
        if(date.equals("2023-6-01")) index = 6;
        return index;
    }
}
