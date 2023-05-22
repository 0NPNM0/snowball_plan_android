package com.example.snowball_plan.tools;

import android.graphics.Color;
import android.widget.Toast;

import com.example.snowball_plan.R;

public class ColorSelector {

    public int one_one,one_two,one_three,one_four,one_five,
            two_one,two_two,two_three,two_four,two_five,
            three_one,three_two,three_three,three_four,three_five,
            four_one,four_two,four_three,four_four,four_five,
            five_one,five_two,five_three,five_four,five_five,
            six_one,six_two,six_three,six_four,six_five,
            seven_one,seven_two,seven_three,seven_four,seven_five;

    private int color;

    public int Selector(int id){
//        color = Color.argb(1,216,66,66);
//
//        if(id == R.id.one_one) color = Color.argb(1,216,66,66);
//        if(id == R.id.one_two) color = Color.argb(1,200,83,83);
//        if(id == R.id.one_three) color = Color.argb(1,224,137,148);
//        if(id == R.id.one_four) color = Color.argb(1,248,181,190);
//        if(id == R.id.one_five) color = Color.argb(1,255,217,221);

        if(id == R.id.one_one) color = R.color.o_one;
        if(id == R.id.one_two) color = R.color.red;
        if(id == R.id.one_three) color = R.color.o_three;
        if(id == R.id.one_four) color = R.color.o_four;
        if(id == R.id.one_five) color = R.color.o_five;

        if(id == R.id.two_one) color = R.color.t_one;
        if(id == R.id.two_two) color = R.color.t_two;
        if(id == R.id.two_three) color = R.color.t_three;
        if(id == R.id.two_four) color = R.color.t_four;
        if(id == R.id.two_five) color = R.color.t_five;

        if(id == R.id.three_one) color = R.color.th_one;
        if(id == R.id.three_two) color = R.color.th_two;
        if(id == R.id.three_three) color = R.color.th_three;
        if(id == R.id.three_four) color = R.color.th_four;
        if(id == R.id.three_five) color = R.color.th_five;

        if(id == R.id.four_one) color = R.color.f_one;
        if(id == R.id.four_two) color = R.color.f_two;
        if(id == R.id.four_three) color =R.color.f_three;
        if(id == R.id.four_four) color = R.color.f_four;
        if(id == R.id.four_five) color = R.color.f_five;

        if(id == R.id.five_one) color = R.color.fi_one;
        if(id == R.id.five_two) color = R.color.fi_two;
        if(id == R.id.five_three) color = R.color.fi_three;
        if(id == R.id.five_four) color = R.color.fi_four;
        if(id == R.id.five_five) color = R.color.fi_five;

        if(id == R.id.six_one) color = R.color.s_one;
        if(id == R.id.six_two) color = R.color.s_two;
        if(id == R.id.six_three) color = R.color.s_three;
        if(id == R.id.six_four) color = R.color.s_four;
        if(id == R.id.six_five) color = R.color.s_five;

        if(id == R.id.seven_one) color = R.color.se_one;
        if(id == R.id.seven_two) color = R.color.se_two;
        if(id == R.id.seven_three) color = R.color.grey;
        if(id == R.id.seven_four) color = R.color.se_four;
        if(id == R.id.seven_five) color = R.color.white;


        return color;
    }

}
