package com.example.snowball_plan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.snowball_plan.R;
//import com.example.snowball_plan.adapter.DayTaskAdapter;
import com.example.snowball_plan.adapter.PlanListAdapter;
import com.example.snowball_plan.database.DayPlanDBHelper;
import com.example.snowball_plan.entity.DayPlan;

import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EveryDayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EveryDayFragment extends Fragment {


    public static EveryDayFragment newInstance(String yearMonth) {
        EveryDayFragment fragment = new EveryDayFragment();
        Bundle args = new Bundle();
        args.putString("yearMonth",yearMonth);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_every_day, container, false);

        ListView lv_plan = view.findViewById(R.id.lv_plan);

        DayPlanDBHelper mDBHelper = DayPlanDBHelper.getInstance(getContext());
        Bundle arguments = getArguments();
        String yearMonth = arguments.getString("yearMonth");
        List<DayPlan> dayPlanList = mDBHelper.queryByMonth(yearMonth);
        Collections.reverse(dayPlanList);
        PlanListAdapter adapter = new PlanListAdapter(getContext(),dayPlanList);
        lv_plan.setAdapter(adapter);

        return view;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}