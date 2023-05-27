package com.example.snowball_plan.fragment;

import static java.lang.Integer.parseInt;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.snowball_plan.R;
import com.example.snowball_plan.adapter.DayPlanAdapter;
import com.example.snowball_plan.database.DayPlanDBHelper;
import com.example.snowball_plan.tools.DateUtil;

import java.util.Calendar;

public class DayFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TextView tv_month;
    private Button jumpto;
    private Calendar calendar;
    private DatePickerDialog dialog;

    private ViewPager vp;
    private String date;


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

        tv_month = view.findViewById(R.id.tv_month);
        jumpto = view.findViewById(R.id.jumpto);

        //显示当前日期
        calendar = Calendar.getInstance();
        tv_month.setText(DateUtil.getDate(calendar));


        dbHelper = DayPlanDBHelper.getInstance(this.getContext());
        dbHelper.openReadLink();
        dbHelper.openWriteLink();


        initViewPager();

        //点击弹出对话框选择日期
        jumpto.setOnClickListener(this);


    }

//    初始化翻页视图
    public void initViewPager() {

        PagerTabStrip pts = getView().findViewById(R.id.day_pick);
        pts.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        pts.setDrawFullUnderline(false);

        vp = getView().findViewById(R.id.day_page);
        DayPlanAdapter adapter = new DayPlanAdapter(getChildFragmentManager(),calendar.get(Calendar.YEAR));
        vp.setAdapter(adapter);
        vp.setCurrentItem(calendar.get(Calendar.MONTH));
    }


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
        tv_month.setText(DateUtil.getDate(calendar));
        vp.setCurrentItem(month);
    }

    protected void destroy(){
        super.onDestroy();
        dbHelper.closeLink();
    }


}