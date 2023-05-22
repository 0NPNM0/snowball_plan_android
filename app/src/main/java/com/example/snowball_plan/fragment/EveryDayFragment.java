package com.example.snowball_plan.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.snowball_plan.R;
//import com.example.snowball_plan.adapter.DayTaskAdapter;
import com.example.snowball_plan.database.DayDBHelper;
import com.example.snowball_plan.entity.DayPlan;
import com.example.snowball_plan.tools.DateUtil;

import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EveryDayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EveryDayFragment extends Fragment {

    public TextView show;
    public Calendar calendar;

    public static EveryDayFragment newInstance(String yearDay) {
        EveryDayFragment fragment = new EveryDayFragment();
        Bundle args = new Bundle();
        args.putString("yearDay",yearDay);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        View view = inflater.inflate(R.layout.fragment_every_day, container, false);

//        ListView lv_day = view.findViewById(R.id.lv_day);
//
//        DayDBHelper mDBHelper = DayDBHelper.getInstance(getContext());
//        Bundle arguments = getArguments();
//        String yearDay = arguments.getString("yearDay");
//        List<DayPlan> dayPlanList = mDBHelper.queryByDay(yearDay);
//        DayTaskAdapter adapter = new DayTaskAdapter(getContext(),dayPlanList);
//        lv_day.setAdapter(adapter);

        return inflater.inflate(R.layout.fragment_every_day, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}