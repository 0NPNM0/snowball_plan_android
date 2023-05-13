package com.example.snowball_plan.tools;

import android.content.Context;

public class ChangeUnit {

    //根据手机分辨率 将单位从 dp 转成 px
    public static int dip2px(Context context, float dpValue){
        //获取当前手机的像素密度（1dp对应几个px）
        float scale = context.getResources().getDisplayMetrics().density;
        //四舍五入取整
        return (int)(dpValue * scale + 0.5f);
    }
}
