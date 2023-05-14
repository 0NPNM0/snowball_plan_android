package com.example.snowball_plan.tools;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.snowball_plan.R;

public class YearDialog extends Dialog {

    private final Button yes;
    private final Button no;

    public YearDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.activity_insert);

        //处理点击事件
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);  //退出程序
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
