package com.example.snowball_plan.tools;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.snowball_plan.R;
import com.example.snowball_plan.adapter.PlanListAdapter;

public class ConfirmDialog extends Dialog {

    public ConfirmDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.confirm_dialog);

    }
}
