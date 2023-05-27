package com.example.snowball_plan.tools;

import android.app.Dialog;
import android.content.Context;
import android.widget.TimePicker;

import androidx.annotation.NonNull;

import com.example.snowball_plan.R;

public class EditDialog extends Dialog {


    public EditDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.edit_dialog);

    }
}
