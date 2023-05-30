package com.example.snowball_plan.tools;


import static android.app.PendingIntent.getActivity;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.snowball_plan.R;
import com.example.snowball_plan.activity.DayActivity;
import com.example.snowball_plan.activity.MainActivity;
import com.example.snowball_plan.database.DayPlanDBHelper;
import com.example.snowball_plan.entity.DayPlan;

import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DayDialog extends Dialog{

    private Button yes_day;
    private Button no_day;

    private Button tab1, tab2, tab3, tab4, tab5,
            tab6, tab7, tab8, tab9, tab10,
            tab11, tab12, tab13, tab14, tab15,
            tab16, tab17, tab18, tab19, tab20,
            tab21, tab22, tab23, tab24, tab25,
            tab26, tab27, tab28, tab29, tab30,
            tab31, tab32, tab33, tab34, tab35, isCurrent;
    private boolean hasColor = false;

    private TimePicker timepicker_start;
    private TimePicker timepicker_end;

    private EditText day_task_type, day_task_list;

    private TextView tv_date;
    private Calendar calendar;
    private ImageView add,tick;

    private DayPlanDBHelper dbHelper;

    private ColorSelector colorSelector;


    public DayDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.activity_day);

        tv_date = findViewById(R.id.tv_date);
        calendar = Calendar.getInstance();
        tv_date.setText(DateUtil.getDate(calendar));

        add = findViewById(R.id.add);
        add.setOnClickListener(this::onClick);
        colorSelector = new ColorSelector();
        tick =findViewById(R.id.tick);

        dbHelper = DayPlanDBHelper.getInstance(this.getContext());
        dbHelper.openReadLink();
        dbHelper.openWriteLink();


        yes_day = findViewById(R.id.yes_day);
        no_day = findViewById(R.id.no_day);


        yes_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DayPlan dayPlan = new DayPlan();
                dayPlan.date = tv_date.getText().toString();
                dayPlan.start_time = timepicker_start.getHour()+":"+timepicker_start.getMinute();
                dayPlan.end_time = timepicker_end.getHour()+":"+timepicker_end.getMinute();
                dayPlan.type = day_task_type.getText().toString();
                dayPlan.list = day_task_list.getText().toString();
                dayPlan.color = colorSelector.Selector(isCurrent.getId());
                dayPlan.tick = false;

                if(dbHelper.save(dayPlan) > 0){

                    Toast.makeText(context,"新建计划成功！",Toast.LENGTH_SHORT).show();

                    Intent mStartActivity = new Intent(context, MainActivity.class);
//                    int mPendingIntentId = 123456;
//                    PendingIntent mPendingIntent = PendingIntent.getActivity(context, mPendingIntentId, mStartActivity, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
//
//                    AlarmManager mgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
//                    mgr.set(AlarmManager.RTC,System.currentTimeMillis() , mPendingIntent);

                    context.startActivity(mStartActivity);

                    dismiss();
                }
            }


        });

        no_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); //让对话框消失
            }
        });

        //时间选择器
        timepicker_end = (TimePicker) findViewById(R.id.timepicker_end);
        timepicker_end.setIs24HourView(true);

        timepicker_end.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String time = hourOfDay+":"+minute;
//                Toast.makeText(context,"您选择的时间是："+hourOfDay+"时"+minute+"分!",Toast.LENGTH_SHORT).show();
            }
        });

        timepicker_start = (TimePicker) findViewById(R.id.timepicker_start);
        timepicker_start.setIs24HourView(true);


        timepicker_start.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String time = hourOfDay+":"+minute;
//                Toast.makeText(context,"您选择的时间是："+hourOfDay+"时"+minute+"分!",Toast.LENGTH_SHORT).show();
            }
        });

        day_task_type = findViewById(R.id.day_task_type);
        day_task_list = findViewById(R.id.day_task_list);



        //颜色选择器
        tab1 = findViewById(R.id.one_one);
        tab2 = findViewById(R.id.one_two);
        tab3 = findViewById(R.id.one_three);
        tab4 = findViewById(R.id.one_four);
        tab5 = findViewById(R.id.one_five);
        tab6 = findViewById(R.id.two_one);
        tab7 = findViewById(R.id.two_two);
        tab8 = findViewById(R.id.two_three);
        tab9 = findViewById(R.id.two_four);
        tab10 = findViewById(R.id.two_five);
        tab11 = findViewById(R.id.three_one);
        tab12 = findViewById(R.id.three_two);
        tab13 = findViewById(R.id.three_three);
        tab14 = findViewById(R.id.three_four);
        tab15 = findViewById(R.id.three_five);
        tab16 = findViewById(R.id.four_one);
        tab17 = findViewById(R.id.four_two);
        tab18 = findViewById(R.id.four_three);
        tab19 = findViewById(R.id.four_four);
        tab20 = findViewById(R.id.four_five);
        tab21 = findViewById(R.id.five_one);
        tab22 = findViewById(R.id.five_two);
        tab23 = findViewById(R.id.five_three);
        tab24 = findViewById(R.id.five_four);
        tab25 = findViewById(R.id.five_five);
        tab26 = findViewById(R.id.six_one);
        tab27 = findViewById(R.id.six_two);
        tab28 = findViewById(R.id.six_three);
        tab29 = findViewById(R.id.six_four);
        tab30 = findViewById(R.id.six_five);
        tab31 = findViewById(R.id.seven_one);
        tab32 = findViewById(R.id.seven_two);
        tab33 = findViewById(R.id.seven_three);
        tab34 = findViewById(R.id.seven_four);
        tab35 = findViewById(R.id.seven_five);

        tab1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab1.setSelected(true);
                    isCurrent = tab1;
                    hasColor = true;
                }else{
                    if(isCurrent == tab1) {
                        tab1.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab1.setSelected(true);
                        isCurrent = tab1;
                    }
                }

            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab2.setSelected(true);
                    isCurrent = tab2;
                    hasColor = true;
                }else{
                    if(isCurrent == tab2) {
                        tab2.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab2.setSelected(true);
                        isCurrent = tab2;
                    }
                }
            }
        });
        tab3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab3.setSelected(true);
                    isCurrent = tab3;
                    hasColor = true;
                }else{
                    if(isCurrent == tab3) {
                        tab3.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab3.setSelected(true);
                        isCurrent = tab3;
                    }
                }
            }
        });
        tab4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab4.setSelected(true);
                    isCurrent = tab4;
                    hasColor = true;
                }else{
                    if(isCurrent == tab4) {
                        tab4.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab4.setSelected(true);
                        isCurrent = tab4;
                    }
                }
            }
        });
        tab5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab5.setSelected(true);
                    isCurrent = tab5;
                    hasColor = true;
                }else{
                    if(isCurrent == tab5) {
                        tab5.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab5.setSelected(true);
                        isCurrent = tab5;
                    }
                }
            }
        });
        tab6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab6.setSelected(true);
                    isCurrent = tab6;
                    hasColor = true;
                }else{
                    if(isCurrent == tab6) {
                        tab6.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab6.setSelected(true);
                        isCurrent = tab6;
                    }
                }
            }
        });
        tab7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab7.setSelected(true);
                    isCurrent = tab7;
                    hasColor = true;
                }else{
                    if(isCurrent == tab7) {
                        tab7.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab7.setSelected(true);
                        isCurrent = tab7;
                    }
                }
            }
        });
        tab8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab8.setSelected(true);
                    isCurrent = tab8;
                    hasColor = true;
                }else{
                    if(isCurrent == tab8) {
                        tab8.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab8.setSelected(true);
                        isCurrent = tab8;
                    }
                }
            }
        });
        tab9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab9.setSelected(true);
                    isCurrent = tab9;
                    hasColor = true;
                }else{
                    if(isCurrent == tab9) {
                        tab9.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab9.setSelected(true);
                        isCurrent = tab9;
                    }
                }
            }
        });
        tab10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab10.setSelected(true);
                    isCurrent = tab10;
                    hasColor = true;
                }else{
                    if(isCurrent == tab10) {
                        tab10.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab10.setSelected(true);
                        isCurrent = tab10;
                    }
                }
            }
        });

        tab11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab11.setSelected(true);
                    isCurrent = tab11;
                    hasColor = true;
                }else{
                    if(isCurrent == tab11) {
                        tab11.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab11.setSelected(true);
                        isCurrent = tab11;
                    }
                }

            }
        });
        tab12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab12.setSelected(true);
                    isCurrent = tab12;
                    hasColor = true;
                }else{
                    if(isCurrent == tab12) {
                        tab12.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab12.setSelected(true);
                        isCurrent = tab12;
                    }
                }
            }
        });
        tab13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab13.setSelected(true);
                    isCurrent = tab13;
                    hasColor = true;
                }else{
                    if(isCurrent == tab13) {
                        tab13.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab13.setSelected(true);
                        isCurrent = tab13;
                    }
                }
            }
        });
        tab14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab14.setSelected(true);
                    isCurrent = tab14;
                    hasColor = true;
                }else{
                    if(isCurrent == tab14) {
                        tab14.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab14.setSelected(true);
                        isCurrent = tab14;
                    }
                }
            }
        });
        tab15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab15.setSelected(true);
                    isCurrent = tab15;
                    hasColor = true;
                }else{
                    if(isCurrent == tab15) {
                        tab15.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab15.setSelected(true);
                        isCurrent = tab15;
                    }
                }
            }
        });
        tab16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab16.setSelected(true);
                    isCurrent = tab16;
                    hasColor = true;
                }else{
                    if(isCurrent == tab16) {
                        tab16.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab16.setSelected(true);
                        isCurrent = tab16;
                    }
                }
            }
        });
        tab17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab17.setSelected(true);
                    isCurrent = tab17;
                    hasColor = true;
                }else{
                    if(isCurrent == tab17) {
                        tab17.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab17.setSelected(true);
                        isCurrent = tab17;
                    }
                }
            }
        });
        tab18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab18.setSelected(true);
                    isCurrent = tab18;
                    hasColor = true;
                }else{
                    if(isCurrent == tab18) {
                        tab18.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab18.setSelected(true);
                        isCurrent = tab18;
                    }
                }
            }
        });
        tab19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab19.setSelected(true);
                    isCurrent = tab19;
                    hasColor = true;
                }else{
                    if(isCurrent == tab19) {
                        tab19.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab19.setSelected(true);
                        isCurrent = tab19;
                    }
                }
            }
        });
        tab20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab20.setSelected(true);
                    isCurrent = tab20;
                    hasColor = true;
                }else{
                    if(isCurrent == tab20) {
                        tab20.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab20.setSelected(true);
                        isCurrent = tab20;
                    }
                }
            }
        });

        tab21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab21.setSelected(true);
                    isCurrent = tab21;
                    hasColor = true;
                }else{
                    if(isCurrent == tab21) {
                        tab21.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab21.setSelected(true);
                        isCurrent = tab21;
                    }
                }

            }
        });
        tab22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab22.setSelected(true);
                    isCurrent = tab22;
                    hasColor = true;
                }else{
                    if(isCurrent == tab22) {
                        tab22.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab22.setSelected(true);
                        isCurrent = tab22;
                    }
                }
            }
        });
        tab23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab23.setSelected(true);
                    isCurrent = tab23;
                    hasColor = true;
                }else{
                    if(isCurrent == tab23) {
                        tab23.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab23.setSelected(true);
                        isCurrent = tab23;
                    }
                }
            }
        });
        tab24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab24.setSelected(true);
                    isCurrent = tab24;
                    hasColor = true;
                }else{
                    if(isCurrent == tab24) {
                        tab24.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab24.setSelected(true);
                        isCurrent = tab24;
                    }
                }
            }
        });
        tab25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab25.setSelected(true);
                    isCurrent = tab25;
                    hasColor = true;
                }else{
                    if(isCurrent == tab25) {
                        tab25.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab25.setSelected(true);
                        isCurrent = tab25;
                    }
                }
            }
        });
        tab26.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab26.setSelected(true);
                    isCurrent = tab26;
                    hasColor = true;
                }else{
                    if(isCurrent == tab26) {
                        tab26.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab26.setSelected(true);
                        isCurrent = tab26;
                    }
                }
            }
        });
        tab27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab27.setSelected(true);
                    isCurrent = tab27;
                    hasColor = true;
                }else{
                    if(isCurrent == tab27) {
                        tab27.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab27.setSelected(true);
                        isCurrent = tab27;
                    }
                }
            }
        });
        tab28.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab28.setSelected(true);
                    isCurrent = tab28;
                    hasColor = true;
                }else{
                    if(isCurrent == tab28) {
                        tab28.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab28.setSelected(true);
                        isCurrent = tab28;
                    }
                }
            }
        });
        tab29.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab29.setSelected(true);
                    isCurrent = tab29;
                    hasColor = true;
                }else{
                    if(isCurrent == tab29) {
                        tab29.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab29.setSelected(true);
                        isCurrent = tab29;
                    }
                }
            }
        });
        tab30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab30.setSelected(true);
                    isCurrent = tab30;
                    hasColor = true;
                }else{
                    if(isCurrent == tab30) {
                        tab30.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab30.setSelected(true);
                        isCurrent = tab30;
                    }
                }
            }
        });

        tab31.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab31.setSelected(true);
                    isCurrent = tab31;
                    hasColor = true;
                }else{
                    if(isCurrent == tab31) {
                        tab31.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab31.setSelected(true);
                        isCurrent = tab31;
                    }
                }

            }
        });
        tab32.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab32.setSelected(true);
                    isCurrent = tab32;
                    hasColor = true;
                }else{
                    if(isCurrent == tab32) {
                        tab32.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab32.setSelected(true);
                        isCurrent = tab32;
                    }
                }
            }
        });
        tab33.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab33.setSelected(true);
                    isCurrent = tab33;
                    hasColor = true;
                }else{
                    if(isCurrent == tab33) {
                        tab33.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab33.setSelected(true);
                        isCurrent = tab33;
                    }
                }
            }
        });
        tab34.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab34.setSelected(true);
                    isCurrent = tab34;
                    hasColor = true;
                }else{
                    if(isCurrent == tab34) {
                        tab34.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab34.setSelected(true);
                        isCurrent = tab34;
                    }
                }
            }
        });
        tab35.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hasColor == false){
                    tab35.setSelected(true);
                    isCurrent = tab35;
                    hasColor = true;
                }else{
                    if(isCurrent == tab35) {
                        tab35.setSelected(false);
                        hasColor =false;
                    }
                    else{
                        isCurrent.setSelected(false);
                        tab35.setSelected(true);
                        isCurrent = tab35;
                    }
                }
            }
        });
    }

    //取消NestedScrollView和EditText冲突
    private void initScrollHandler() {
        View mEditOpinionContent = findViewById(R.id.scoll_year);
        mEditOpinionContent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //canScrollVertically()方法为判断指定方向上是否可以滚动,参数为正数或负数,负数检查向上是否可以滚动,正数为检查向下是否可以滚动
                if (mEditOpinionContent.canScrollVertically(1) || mEditOpinionContent.canScrollVertically(-1)) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);//requestDisallowInterceptTouchEvent();要求父类布局不在拦截触摸事件
                    if (event.getAction() == MotionEvent.ACTION_UP) { //判断是否松开
                        v.getParent().requestDisallowInterceptTouchEvent(false); //requestDisallowInterceptTouchEvent();让父类布局继续拦截触摸事件
                    }
                }
                return false;
            }
        });
    }

    public void onClick(View v) {
        if(R.id.add == v.getId()){
            DatePickerDialog dialog =new DatePickerDialog(getContext(), R.style.ThemeDialog,this::onDateSet,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            dialog.show();

            Button button_yes = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
            button_yes.setText("确定");
            button_yes.setTextSize(20);
            button_yes.setTextColor(Color.BLACK);


            Button button_no = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
            button_no.setText("取消");
            button_no.setTextSize(20);
            button_no.setTextColor(Color.BLACK);
        }
    }


    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        tv_date.setText(DateUtil.getDate(calendar));
    }


}
