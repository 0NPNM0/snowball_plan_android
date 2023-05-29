package com.example.snowball_plan.fragment;

import static java.lang.Integer.parseInt;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.snowball_plan.R;
import com.example.snowball_plan.adapter.MyFragmentStateVPAdapter;
import com.example.snowball_plan.database.DayPlanDBHelper;
import com.example.snowball_plan.tools.DateUtil;
import com.example.snowball_plan.tools.MatchDate;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DayFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TextView tv_month;
    private Button jumpto;
    private Calendar calendarNow,calendar,calendar1,calendar2,calendar3,calendar4,calendar5,calendar6;
    private DatePickerDialog dialog;

    private ViewPager vp;
    private TabLayout tl;
    private List<Fragment> fragmentListDay;
    private List<String> mTitleListYear;
    private MyFragmentStateVPAdapter myFragmentStateVPAdapter;


    private DayPlanDBHelper dbHelper;

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

//        tv_month = view.findViewById(R.id.tv_month);
//        jumpto = view.findViewById(R.id.jumpto);

        //显示当前日期
        calendarNow = Calendar.getInstance();

        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2023);
        calendar.set(Calendar.MONTH,4);
        calendar.set(Calendar.DAY_OF_MONTH,26);

        calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.YEAR,2023);
        calendar1.set(Calendar.MONTH,4);
        calendar1.set(Calendar.DAY_OF_MONTH,27);

        calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.YEAR,2023);
        calendar2.set(Calendar.MONTH,4);
        calendar2.set(Calendar.DAY_OF_MONTH,28);

        calendar3 = Calendar.getInstance();
        calendar3.set(Calendar.YEAR,2023);
        calendar3.set(Calendar.MONTH,4);
        calendar3.set(Calendar.DAY_OF_MONTH,29);

        calendar4 = Calendar.getInstance();
        calendar4.set(Calendar.YEAR,2023);
        calendar4.set(Calendar.MONTH,4);
        calendar4.set(Calendar.DAY_OF_MONTH,30);

        calendar5 = Calendar.getInstance();
        calendar5.set(Calendar.YEAR,2023);
        calendar5.set(Calendar.MONTH,4);
        calendar5.set(Calendar.DAY_OF_MONTH,31);


        calendar6 = Calendar.getInstance();
        calendar6.set(Calendar.YEAR,2023);
        calendar6.set(Calendar.MONTH,5);
        calendar6.set(Calendar.DAY_OF_MONTH,1);
//        tv_month.setText(DateUtil.getDate(calendarNow));

        dbHelper = DayPlanDBHelper.getInstance(this.getContext());
        dbHelper.openReadLink();
        dbHelper.openWriteLink();

        //点击弹出对话框选择日期
//        jumpto.setOnClickListener(this);


        vp =view.findViewById(R.id.day_page);
        tl = view.findViewById(R.id.tab_layout_day);

        initYearFragmentData();

        myFragmentStateVPAdapter = new MyFragmentStateVPAdapter(getChildFragmentManager(),fragmentListDay,mTitleListYear);
        vp.setAdapter(myFragmentStateVPAdapter);


        tl.setupWithViewPager(vp);
        MatchDate m = new MatchDate();
        tl.getTabAt(3).select();

    }

    //    初始化翻页视图
    public void initYearFragmentData() {

        fragmentListDay = new ArrayList<>();
        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR,2023);
//        c.set(Calendar.MONTH,5);
//        c.set(Calendar.DAY_OF_MONTH,28);
        EveryDayFragment fragment1 = EveryDayFragment.newInstance(DateUtil.getDate(calendar));
        EveryDayFragment fragment2 = EveryDayFragment.newInstance(DateUtil.getDate(calendar1));
        EveryDayFragment fragment3 = EveryDayFragment.newInstance(DateUtil.getDate(calendar2));
        EveryDayFragment fragment4 = EveryDayFragment.newInstance(DateUtil.getDate(calendar3));
        EveryDayFragment fragment5 = EveryDayFragment.newInstance(DateUtil.getDate(calendar4));
        EveryDayFragment fragment6 = EveryDayFragment.newInstance(DateUtil.getDate(calendar5));
        EveryDayFragment fragment7 = EveryDayFragment.newInstance(DateUtil.getDate(calendar6));

        fragmentListDay.add(fragment1);
        fragmentListDay.add(fragment2);
        fragmentListDay.add(fragment3);
        fragmentListDay.add(fragment4);
        fragmentListDay.add(fragment5);
        fragmentListDay.add(fragment6);
        fragmentListDay.add(fragment7);

        mTitleListYear = new ArrayList<>();
        mTitleListYear.add("2023-5-26");
        mTitleListYear.add("2023-5-27");
        mTitleListYear.add("2023-5-28");
        mTitleListYear.add("2023-5-29");
        mTitleListYear.add("2023-5-30");
        mTitleListYear.add("2023-5-31");
        mTitleListYear.add("2023-6-01");


//        PagerTabStrip pts = getView().findViewById(R.id.day_pick);
//        pts.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
//        pts.setDrawFullUnderline(false);

//        vp = getView().findViewById(R.id.day_page);
//        DayPlanAdapter adapter = new DayPlanAdapter(getChildFragmentManager(),calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH));
//        vp.setAdapter(adapter);
//        vp.setCurrentItem(2003);
    }


//    @Override
//    public void onClick(View v) {
//        if (R.id.jumpto == v.getId()) {
//            DatePickerDialog dialog = new DatePickerDialog(this.getContext(), R.style.ThemeDialog,this,
//                    calendar.get(Calendar.YEAR),
//                    calendar.get(Calendar.MONTH),
//                    calendar.get(Calendar.DAY_OF_MONTH));
//            dialog.show();
//            Button button_yes = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
//            button_yes.setText("确定");
//            button_yes.setTextSize(20);
////            button_yes.setBackgroundResource(R.color.grey);
//            button_yes.setTextColor(getResources().getColor(R.color.black));
//
//            Button button_no = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
//            button_no.setText("取消");
//            button_no.setTextSize(20);
//            button_no.setTextColor(getResources().getColor(R.color.black));
////            button_no.setBackgroundResource(R.color.grey);
//        }
//    }
//
//    @Override
//    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//        calendar.set(Calendar.YEAR, year);
//        calendar.set(Calendar.MONTH, month);
//        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//        tv_month.setText(DateUtil.getDate(calendar));
////        vp.setCurrentItem(4);
//    }

    protected void destroy(){
        super.onDestroy();
        dbHelper.closeLink();
    }


}