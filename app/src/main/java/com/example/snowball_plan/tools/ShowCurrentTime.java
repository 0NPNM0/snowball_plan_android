package com.example.snowball_plan.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowCurrentTime {

    public static String getNowTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:MM:SS");
        return simpleDateFormat.format(new Date());
    }
}
