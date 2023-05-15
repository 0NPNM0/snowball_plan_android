package com.example.snowball_plan.fragment;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.snowball_plan.R;
import com.example.snowball_plan.adapter.MyFragmentStateVPAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class VPYearFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private ViewPager mViewPagerYear;
    private TabLayout mtablayoutYear;
    private List<Fragment> fragmentListYear;
    private List<String> mTitleListYear;
    private MyFragmentStateVPAdapter myFragmentStateVPAdapter;

    public VPYearFragment() {
        // Required empty public constructor
    }

    public static VPYearFragment newInstance(String param1, String param2) {
        VPYearFragment fragment = new VPYearFragment();
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
        return inflater.inflate(R.layout.fragment_v_p_year, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPagerYear =view.findViewById(R.id.vp_month);
        mtablayoutYear = view.findViewById(R.id.tab_layout_year);

        initYearFragmentData();

        myFragmentStateVPAdapter = new MyFragmentStateVPAdapter(getChildFragmentManager(),fragmentListYear,mTitleListYear);
        mViewPagerYear.setAdapter(myFragmentStateVPAdapter);

        mtablayoutYear.setupWithViewPager(mViewPagerYear);
        mtablayoutYear.getTabAt(3).select();
    }

    private void initYearFragmentData() {

        fragmentListYear = new ArrayList<>();
        YearCellFragment fragment2020 = YearCellFragment.newInstance("2020","");
        YearCellFragment fragment2021 = YearCellFragment.newInstance("2021","");
        YearCellFragment fragment2022 = YearCellFragment.newInstance("2022","");
        YearCellFragment fragment2023 = YearCellFragment.newInstance("2023","");
        YearCellFragment fragment2024 = YearCellFragment.newInstance("2024","");
        YearCellFragment fragment2025 = YearCellFragment.newInstance("2025","");
        YearCellFragment fragment2026 = YearCellFragment.newInstance("2026","");

        fragmentListYear.add(fragment2020);
        fragmentListYear.add(fragment2021);
        fragmentListYear.add(fragment2022);
        fragmentListYear.add(fragment2023);
        fragmentListYear.add(fragment2024);
        fragmentListYear.add(fragment2025);
        fragmentListYear.add(fragment2026);

        mTitleListYear = new ArrayList<>();
        mTitleListYear.add("2020");
        mTitleListYear.add("2021");
        mTitleListYear.add("2022");
        mTitleListYear.add("2023");
        mTitleListYear.add("2024");
        mTitleListYear.add("2025");
        mTitleListYear.add("2026");

    }
}