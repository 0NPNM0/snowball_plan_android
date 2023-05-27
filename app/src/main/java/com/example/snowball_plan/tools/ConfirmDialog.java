package com.example.snowball_plan.tools;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.snowball_plan.R;
import com.example.snowball_plan.adapter.PlanListAdapter;

public class ConfirmDialog extends Dialog {

    private final Button yes;
    private final Button no;

    public int status;

    public ConfirmDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.confirm_dialog);

        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               status = 1;
               Toast.makeText(context,"删除计划成功！",Toast.LENGTH_SHORT).show();
               dismiss();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss(); //让对话框消失
            }
        });
    }

}
