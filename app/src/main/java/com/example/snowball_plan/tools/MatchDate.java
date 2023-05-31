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

   public int judge(String d){

       calendar.set(Calendar.YEAR,2023);
       calendar.set(Calendar.MONTH,4);
       calendar.set(Calendar.DAY_OF_MONTH,29);
       String date = DateUtil.getDate(calendar);

       if(!date.equals(d)){
          ++i;
       }
       return i;
   }

}
