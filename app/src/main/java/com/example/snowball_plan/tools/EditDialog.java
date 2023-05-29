package com.example.snowball_plan.tools;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;

import com.example.snowball_plan.R;

import java.util.Calendar;

public class EditDialog extends Dialog {
//    private TextView tv_date;
//    private Calendar calendar;
//    private ImageView add;
    public EditDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.edit_dialog);

    }

}
