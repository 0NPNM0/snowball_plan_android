package com.example.snowball_plan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.snowball_plan.R;

public class PickMonthActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    public void onClick(View v) {

        setContentView(R.layout.activity_pick_month);
    }
}