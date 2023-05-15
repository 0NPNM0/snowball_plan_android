package com.example.snowball_plan.tools;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.snowball_plan.R;

public class YearDialog extends Dialog{

    private final Button yes;
    private final Button no;

    //取消NestedScrollView和EditText冲突
    private void initScrollHandler(){
        View mEditOpinionContent = findViewById(R.id.scoll_year);
        mEditOpinionContent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //canScrollVertically()方法为判断指定方向上是否可以滚动,参数为正数或负数,负数检查向上是否可以滚动,正数为检查向下是否可以滚动
                if (mEditOpinionContent.canScrollVertically(1) || mEditOpinionContent.canScrollVertically(-1)){
                    v.getParent().requestDisallowInterceptTouchEvent(true);//requestDisallowInterceptTouchEvent();要求父类布局不在拦截触摸事件
                    if (event.getAction() == MotionEvent.ACTION_UP){ //判断是否松开
                        v.getParent().requestDisallowInterceptTouchEvent(false); //requestDisallowInterceptTouchEvent();让父类布局继续拦截触摸事件
                    }
                }
                return false;
            }
        });

    }


    public YearDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.activity_insert);

        //处理点击事件
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);

        View recyclerView = findViewById(R.id.scoll_year);
        recyclerView.setNestedScrollingEnabled(false);

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
