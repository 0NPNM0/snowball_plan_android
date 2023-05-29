package com.example.snowball_plan.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.snowball_plan.fragment.EveryDayFragment;

import java.util.ArrayList;
import java.util.List;

public class DayPlanAdapter extends FragmentStatePagerAdapter {

    private final int mYear;
    private final int mMonth;

    private Context context;

    List<Fragment> fragmentList = new ArrayList<>();

    public DayPlanAdapter(@NonNull FragmentManager fm, int year,int month) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mYear = year;
        this.mMonth = month;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

//        int month = position + 1;
//        String zeroMonth = month < 10 ? "0" + month : String.valueOf(month);
//        String yearMonth = mYear + "-"+ zeroMonth;

        int day = position ;
        String zeroMonth = day < 10 ? "0" + day : String.valueOf(day);
        String yearMonth = mYear+"-"+mMonth+"-"+day;

        Log.d("ning",yearMonth);
        return EveryDayFragment.newInstance(yearMonth);
    }

    @Override
    public int getCount() {
        return 31;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return position  + "号";
    }
}
