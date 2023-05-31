package com.example.snowball_plan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.snowball_plan.R;
import com.example.snowball_plan.activity.MainActivity;
import com.example.snowball_plan.adapter.MonthFragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MonthFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private List<Fragment> fragmentListMonth;
    private List<String> mTitleListMonth;
    private MonthFragmentPagerAdapter monthFragmentPagerAdapter;
    private ViewPager mViewPagerMonth;
    private FragmentActivity mContext;
    private TabLayout mTabLayoutMonth;
   // private String year;
    private TwentyeightDayFragment fragment2;
    private TewntynineDayFragment fragment2_2;
    private monthCallBack monthcallback;

    public MonthFragment() {
        // Required empty public constructor

    }

    // TODO: Rename and change types and number of parameters
    public static MonthFragment newInstance(String param1, String param2) {
        MonthFragment fragment = new MonthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(!(context instanceof monthCallBack)){
            throw new IllegalStateException("又错啦");
        }
        monthcallback = (monthCallBack) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext=getActivity();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public interface monthCallBack{
        void sendmonthtoMainactivity(String month);
    }




    private void onClickBuild(View view) {

        //MonthDialog monthDialog = new MonthDialog(getActivity(), R.style.yearBuildDialog);
       // monthDialog.show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_month, container, false);
        //Toast.makeText(getActivity(),year,Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPagerMonth = view.findViewById(R.id.vp_day);
        mTabLayoutMonth = view.findViewById(R.id.tab_layout_month);
        Calendar calendar=Calendar.getInstance();
        int index=calendar.get(Calendar.MONTH);

        FragmentManager fragmentManager= getChildFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();

        
        initMonthFragmentData();

        //MyFragmentStateVPAdapter myFragmentStateVPAdapter = new MyFragmentStateVPAdapter(getChildFragmentManager(),fragmentListMonth,mTitleListMonth);
        //mViewPagerMonth.setAdapter(myFragmentStateVPAdapter);
        monthFragmentPagerAdapter = new MonthFragmentPagerAdapter(getChildFragmentManager(),fragmentListMonth,mTitleListMonth);
        mViewPagerMonth.setAdapter(monthFragmentPagerAdapter);

        mTabLayoutMonth.setupWithViewPager(mViewPagerMonth);
        mTabLayoutMonth.getTabAt(index).select();
        mTabLayoutMonth.getSelectedTabPosition();

        mTabLayoutMonth.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String month=String.valueOf(mTabLayoutMonth.getSelectedTabPosition()+1);


                monthcallback.sendmonthtoMainactivity(month);
                Toast.makeText(mContext,month,Toast.LENGTH_SHORT).show();

                if (mTabLayoutMonth.getTabAt(1).isSelected()){
                 //  Toast.makeText(getActivity(),year,Toast.LENGTH_SHORT).show();

//                    if(year.equals(2023)){
//                        Toast.makeText(getActivity(),"2929292",Toast.LENGTH_SHORT).show();
//                    }
//                    if(year.equals(2022)){
//                        Toast.makeText(getActivity(),"28282882",Toast.LENGTH_SHORT).show();
//                    }
//                    switch (year){
//
//                        case "2020":
//                        case "2024":
//
//                            Toast.makeText(getActivity(),"2929292",Toast.LENGTH_SHORT).show();
//                            break;
//                        case "2021":
//                        case "2022":
//                        case "2023":
//                        case "2025":
//                        case "2026":
//                            Toast.makeText(getActivity(),"28282828",Toast.LENGTH_SHORT).show();
//                            break;
//                    }


                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    private void initMonthFragmentData() {

        fragmentListMonth =new ArrayList<>();

        //单数月份要写一个框架--->signalMonthCellFragment
        //双数月份写另一个框架---->evenMonthCellFragment
        //2月份单独一个框架--->FebFragment
        SingalMonthCellFragment fragment1= SingalMonthCellFragment.newInstance("1月", "");
        TwentyeightDayFragment fragment2_1=TwentyeightDayFragment.newInstance("2月","");
        SingalMonthCellFragment fragment3= SingalMonthCellFragment.newInstance("3月", "");
        EvenMonthCellFragment fragment4= EvenMonthCellFragment.newInstance("4月", "");
        SingalMonthCellFragment fragment5= SingalMonthCellFragment.newInstance("5月", "");
        EvenMonthCellFragment fragment6= EvenMonthCellFragment.newInstance("6月", "");
        SingalMonthCellFragment fragment7= SingalMonthCellFragment.newInstance("7月", "");
        SingalMonthCellFragment fragment8= SingalMonthCellFragment.newInstance("8月", "");
        EvenMonthCellFragment fragment9= EvenMonthCellFragment.newInstance("9月", "");
        SingalMonthCellFragment fragment10= SingalMonthCellFragment.newInstance("10月", "");
        EvenMonthCellFragment fragment11= EvenMonthCellFragment.newInstance("11月", "");
        SingalMonthCellFragment fragment12= SingalMonthCellFragment.newInstance("12月", "");


        fragmentListMonth.add(fragment1);
       // switch (year){
         //   case "2021":
         //   case "2022":
         //   case "2023":
         //   case "2025":
         //   case "2026":
                //TwentyeightDayFragment fragment2_1=TwentyeightDayFragment.newInstance("2月","");
                fragmentListMonth.add(fragment2_1);
            //    break;
          //  case "2020":
          //  case "2024":
          //      TewntynineDayFragment fragment2_2=TewntynineDayFragment.newInstance("2月","");
          //      fragmentListMonth.add(fragment2_2);
          ///      break;
       // }


        fragmentListMonth.add(fragment3);
        fragmentListMonth.add(fragment4);
        fragmentListMonth.add(fragment5);
        fragmentListMonth.add(fragment6);
        fragmentListMonth.add(fragment7);
        fragmentListMonth.add(fragment8);
        fragmentListMonth.add(fragment9);
        fragmentListMonth.add(fragment10);
        fragmentListMonth.add(fragment11);
        fragmentListMonth.add(fragment12);


        mTitleListMonth =new ArrayList<>();
        mTitleListMonth.add("1月");
        mTitleListMonth.add("2月");
        mTitleListMonth.add("3月");
        mTitleListMonth.add("4月");
        mTitleListMonth.add("5月");
        mTitleListMonth.add("6月");
        mTitleListMonth.add("7月");
        mTitleListMonth.add("8月");
        mTitleListMonth.add("9月");
        mTitleListMonth.add("10月");
        mTitleListMonth.add("11月");
        mTitleListMonth.add("12月");


    }
}