package com.example.snowball_plan.tools;

import android.graphics.Color;
import android.widget.Toast;

import com.example.snowball_plan.R;
import com.example.snowball_plan.entity.DayPlan;

public class ColorSelector {

    private int color;

    public int Selector(int id){

        if(id == R.id.one_one)   color = 0xFFD84242;
        if(id == R.id.one_two)   color = 0xFFC85353;
        if(id == R.id.one_three) color = 0xFFE08994;
        if(id == R.id.one_four)  color = 0xFFF8B5BE;
        if(id == R.id.one_five)  color = 0xFFFFD9DD;

        if(id == R.id.two_one)   color = 0xFFDF8E00;
        if(id == R.id.two_two)   color = 0xFFDA9F38;
        if(id == R.id.two_three) color = 0xFFE8B968;
        if(id == R.id.two_four)  color = 0xFFF8D79F;
        if(id == R.id.two_five)  color = 0xFFFFEAC6;

        if(id == R.id.three_one)   color = 0xFFE2C602;
        if(id == R.id.three_two)   color = 0xFFE8D64F;
        if(id == R.id.three_three) color = 0xFFE9DA6D;
        if(id == R.id.three_four)  color = 0xFFF1E8A4;
        if(id == R.id.three_five)  color = 0xFFFAF6D9;

        if(id == R.id.four_one)   color = 0xFF008409;
        if(id == R.id.four_two)   color = 0xFF289B30;
        if(id == R.id.four_three) color = 0xFF62BA5B;
        if(id == R.id.four_four)  color = 0xFF8BD46B;
        if(id == R.id.four_five)  color = 0xFFBAE3A8;

        if(id == R.id.five_one)   color = 0xFF2C63C8;
        if(id == R.id.five_two)   color = 0xFF4E7CD0;
        if(id == R.id.five_three) color = 0xFF7D9FDD;
        if(id == R.id.five_four)  color = 0xFFA5BDEA;
        if(id == R.id.five_five)  color = 0xFFC2D4F5;

        if(id == R.id.six_one)   color = 0xFF7E40B4;
        if(id == R.id.six_two)   color = 0xFF9749D8;
        if(id == R.id.six_three) color = 0xFFBD84ED;
        if(id == R.id.six_four)  color = 0xFFD4A4FB;
        if(id == R.id.six_five)  color = 0xFFE7C9FF;

        if(id == R.id.seven_one)   color = 0xFF787878;
        if(id == R.id.seven_two)   color = 0xFF9E9999;
        if(id == R.id.seven_three) color = 0xFFC4C4C4;
        if(id == R.id.seven_four)  color = 0xFFE0E0E0;
        if(id == R.id.seven_five)  color = 0xFFFFFFFF;


        return color;
    }

}
