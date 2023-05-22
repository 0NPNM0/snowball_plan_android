package com.example.snowball_plan.fragment;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Constraints;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.snowball_plan.R;
import com.example.snowball_plan.adapter.DayPickAdapter;
import com.example.snowball_plan.database.DayDBHelper;
import com.example.snowball_plan.entity.DayPlan;
import com.example.snowball_plan.tools.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DayFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TextView current_day;
    private Button jumpto;
    private Calendar calendar;
    private DatePickerDialog dialog;

    private ViewPager vp;


//    private DayDBHelper dbHelper;

    public DayFragment() {

    }

    public static DayFragment newInstance(String param1, String param2) {
        DayFragment fragment = new DayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_day, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        current_day = view.findViewById(R.id.current_day);
        jumpto = view.findViewById(R.id.jumpto);

        //显示当前日期
        calendar = Calendar.getInstance();
        current_day.setText(DateUtil.getDate(calendar));

        //点击弹出对话框选择日期
        jumpto.setOnClickListener(this);

        view.findViewById(R.id.day_page);

//        dbHelper = DayDBHelper.getInstance(this.getContext());
//        dbHelper.openWriteLink();
//        dbHelper.openWriteLink();

//        initYearFragmentData();
        initViewPager();
    }

//    初始化翻页视图
    public void initViewPager() {
        PagerTabStrip pts = getView().findViewById(R.id.day_pick);
        pts.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        pts.setDrawFullUnderline(false);
        vp = getView().findViewById(R.id.day_page);
//        ,fragmentListDay
        DayPickAdapter adapter = new DayPickAdapter(getParentFragmentManager(),calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH));
        vp.setAdapter(adapter);
        vp.setCurrentItem(calendar.get(Calendar.DAY_OF_MONTH)-1);
    }

//    private void initYearFragmentData() {
//        fragmentListDay = new ArrayList<>();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        String yearDay = year +"-"+ month+"-" +day;
//
//        if( month == 2){
//            if((year%4 == 0 && year%100 != 0 )||(year %400 == 0)){
//                for(int i = 1;i <= 29;i++){
//                    EveryDayFragment j = EveryDayFragment.newInstance(yearDay);
//                    fragmentListDay.add(j);
//                }
//            }
//            else {
//                for(int i = 1;i <= 28;i++){
//                    EveryDayFragment j = EveryDayFragment.newInstance(yearDay);
//                    fragmentListDay.add(j);
//                }
//            }
//        }else if( month == 4 || month == 6 || month == 9 || month == 11 ){
//            for(int i = 1;i <= 30;i++){
//                EveryDayFragment j = EveryDayFragment.newInstance(yearDay);
//                fragmentListDay.add(j);
//            }
//        }else if ( month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
//            for(int i = 1;i <= 31;i++){
//                EveryDayFragment j = EveryDayFragment.newInstance(yearDay);
//                fragmentListDay.add(j);
//            }
//        }
//    }

    @Override
    public void onClick(View v) {
        if (R.id.jumpto == v.getId()) {
            DatePickerDialog dialog = new DatePickerDialog(this.getContext(), R.style.ThemeDialog,this,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));

            dialog.show();
            Button button_yes = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
            button_yes.setText("确定");
            button_yes.setTextSize(20);
//            button_yes.setBackgroundResource(R.color.grey);
            button_yes.setTextColor(getResources().getColor(R.color.black));


            Button button_no = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
            button_no.setText("取消");
            button_no.setTextSize(20);
            button_no.setTextColor(getResources().getColor(R.color.black));
//            button_no.setBackgroundResource(R.color.grey);
        }
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        current_day.setText(DateUtil.getDate(calendar));
    }

//    protected void onDestory(){
//        dbHelper.closeLink();
//    }
}