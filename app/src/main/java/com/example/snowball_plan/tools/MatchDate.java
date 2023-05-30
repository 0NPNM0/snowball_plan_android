package com.example.snowball_plan.tools;

import java.util.Calendar;

public class MatchDate {

   int i = 29;

   Calendar calendar =Calendar.getInstance();

//   public void change(int year, int month, int day){
//       calendar.set(Calendar.YEAR,year);
//       calendar.set(Calendar.MONTH,month);
//       calendar.set(Calendar.DAY_OF_MONTH,day);
//   }

   String date = DateUtil.getDate(calendar);
   public int judge(String d){

       if(!date.equals(d)){
          ++i;
          date = d;
       }
       return i;
   }

}
