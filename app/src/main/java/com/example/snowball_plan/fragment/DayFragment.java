package com.example.snowball_plan.fragment;

import static java.lang.Integer.parseInt;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.snowball_plan.R;
import com.example.snowball_plan.adapter.MyFragmentStateVPAdapter;
import com.example.snowball_plan.database.DayPlanDBHelper;
import com.example.snowball_plan.tools.DateUtil;
import com.example.snowball_plan.tools.MatchDate;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class DayFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

//    private TextView tv_month;
//    private Button jumpto;
    private Calendar calendarNow,
            calendar501,calendar502,calendar503,calendar504,calendar505,calendar506,calendar507,calendar508,calendar509,calendar510,
            calendar511,calendar512,calendar513,calendar514,calendar515,calendar516,calendar517,calendar518,calendar519,calendar520,
            calendar521,calendar522,calendar523,calendar524,calendar525,calendar526,calendar527,calendar528,calendar529,calendar530,calendar531,

            calendar601,calendar602,calendar603,calendar604,calendar605,calendar606,calendar607,calendar608,calendar609,calendar610,
            calendar611,calendar612,calendar613,calendar614,calendar615,calendar616,calendar617,calendar618,calendar619,calendar620,
            calendar621,calendar622,calendar623,calendar624,calendar625,calendar626,calendar627,calendar628,calendar629,calendar630,

            calendar701,calendar702,calendar703,calendar704,calendar705,calendar706,calendar707,calendar708,calendar709,calendar710,
            calendar711,calendar712,calendar713,calendar714,calendar715,calendar716,calendar717,calendar718,calendar719,calendar720,
            calendar721,calendar722,calendar723,calendar724,calendar725,calendar726,calendar727,calendar728,calendar729,calendar730,calendar731,

            calendar801,calendar802,calendar803,calendar804,calendar805,calendar806,calendar807,calendar808,calendar809,calendar810,
            calendar811,calendar812,calendar813,calendar814,calendar815,calendar816,calendar817,calendar818,calendar819,calendar820,
            calendar821,calendar822,calendar823,calendar824,calendar825,calendar826,calendar827,calendar828,calendar829,calendar830,calendar831,


            calendar901,calendar902,calendar903,calendar904,calendar905,calendar906,calendar907,calendar908,calendar909,calendar910,
            calendar911,calendar912,calendar913,calendar914,calendar915,calendar916,calendar917,calendar918,calendar919,calendar920,
            calendar921,calendar922,calendar923,calendar924,calendar925,calendar926,calendar927,calendar928,calendar929,calendar930;

    private DatePickerDialog dialog;

    private ViewPager vp;
    private TabLayout tl;
    private List<Fragment> fragmentListDay;
    private List<String> mTitleListYear;
    private MyFragmentStateVPAdapter myFragmentStateVPAdapter;

    private final ArrayList<TabLayout.Tab> tabs = new ArrayList<>();

    public int i;


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


        calendar501 = Calendar.getInstance();
        calendar501.set(Calendar.YEAR,2023);
        calendar501.set(Calendar.MONTH,4);
        calendar501.set(Calendar.DAY_OF_MONTH,1);

        calendar502 = Calendar.getInstance();
        calendar502.set(Calendar.YEAR,2023);
        calendar502.set(Calendar.MONTH,4);
        calendar502.set(Calendar.DAY_OF_MONTH,2);

        calendar503 = Calendar.getInstance();
        calendar503.set(Calendar.YEAR,2023);
        calendar503.set(Calendar.MONTH,4);
        calendar503.set(Calendar.DAY_OF_MONTH,3);

        calendar504 = Calendar.getInstance();
        calendar504.set(Calendar.YEAR,2023);
        calendar504.set(Calendar.MONTH,4);
        calendar504.set(Calendar.DAY_OF_MONTH,4);

        calendar505 = Calendar.getInstance();
        calendar505.set(Calendar.YEAR,2023);
        calendar505.set(Calendar.MONTH,4);
        calendar505.set(Calendar.DAY_OF_MONTH,5);

        calendar506 = Calendar.getInstance();
        calendar506.set(Calendar.YEAR,2023);
        calendar506.set(Calendar.MONTH,4);
        calendar506.set(Calendar.DAY_OF_MONTH,6);

        calendar507 = Calendar.getInstance();
        calendar507.set(Calendar.YEAR,2023);
        calendar507.set(Calendar.MONTH,4);
        calendar507.set(Calendar.DAY_OF_MONTH,7);


        calendar508 = Calendar.getInstance();
        calendar508.set(Calendar.YEAR,2023);
        calendar508.set(Calendar.MONTH,4);
        calendar508.set(Calendar.DAY_OF_MONTH,8);

        calendar509 = Calendar.getInstance();
        calendar509.set(Calendar.YEAR,2023);
        calendar509.set(Calendar.MONTH,4);
        calendar509.set(Calendar.DAY_OF_MONTH,9);

        calendar510 = Calendar.getInstance();
        calendar510.set(Calendar.YEAR,2023);
        calendar510.set(Calendar.MONTH,4);
        calendar510.set(Calendar.DAY_OF_MONTH,10);

        calendar511 = Calendar.getInstance();
        calendar511.set(Calendar.YEAR,2023);
        calendar511.set(Calendar.MONTH,4);
        calendar511.set(Calendar.DAY_OF_MONTH,11);

        calendar512 = Calendar.getInstance();
        calendar512.set(Calendar.YEAR,2023);
        calendar512.set(Calendar.MONTH,4);
        calendar512.set(Calendar.DAY_OF_MONTH,12);

        calendar513 = Calendar.getInstance();
        calendar513.set(Calendar.YEAR,2023);
        calendar513.set(Calendar.MONTH,4);
        calendar513.set(Calendar.DAY_OF_MONTH,13);

        calendar514 = Calendar.getInstance();
        calendar514.set(Calendar.YEAR,2023);
        calendar514.set(Calendar.MONTH,4);
        calendar514.set(Calendar.DAY_OF_MONTH,14);

        calendar515 = Calendar.getInstance();
        calendar515.set(Calendar.YEAR,2023);
        calendar515.set(Calendar.MONTH,4);
        calendar515.set(Calendar.DAY_OF_MONTH,15);

        calendar516 = Calendar.getInstance();
        calendar516.set(Calendar.YEAR,2023);
        calendar516.set(Calendar.MONTH,4);
        calendar516.set(Calendar.DAY_OF_MONTH,16);

        calendar517 = Calendar.getInstance();
        calendar517.set(Calendar.YEAR,2023);
        calendar517.set(Calendar.MONTH,4);
        calendar517.set(Calendar.DAY_OF_MONTH,17);


        calendar518 = Calendar.getInstance();
        calendar518.set(Calendar.YEAR,2023);
        calendar518.set(Calendar.MONTH,4);
        calendar518.set(Calendar.DAY_OF_MONTH,18);

        calendar519 = Calendar.getInstance();
        calendar519.set(Calendar.YEAR,2023);
        calendar519.set(Calendar.MONTH,4);
        calendar519.set(Calendar.DAY_OF_MONTH,19);

        calendar520 = Calendar.getInstance();
        calendar520.set(Calendar.YEAR,2023);
        calendar520.set(Calendar.MONTH,4);
        calendar520.set(Calendar.DAY_OF_MONTH,20);

        calendar521 = Calendar.getInstance();
        calendar521.set(Calendar.YEAR,2023);
        calendar521.set(Calendar.MONTH,4);
        calendar521.set(Calendar.DAY_OF_MONTH,21);

        calendar522 = Calendar.getInstance();
        calendar522.set(Calendar.YEAR,2023);
        calendar522.set(Calendar.MONTH,4);
        calendar522.set(Calendar.DAY_OF_MONTH,22);

        calendar523 = Calendar.getInstance();
        calendar523.set(Calendar.YEAR,2023);
        calendar523.set(Calendar.MONTH,4);
        calendar523.set(Calendar.DAY_OF_MONTH,23);

        calendar524 = Calendar.getInstance();
        calendar524.set(Calendar.YEAR,2023);
        calendar524.set(Calendar.MONTH,4);
        calendar524.set(Calendar.DAY_OF_MONTH,24);


        calendar525 = Calendar.getInstance();
        calendar525.set(Calendar.YEAR,2023);
        calendar525.set(Calendar.MONTH,4);
        calendar525.set(Calendar.DAY_OF_MONTH,25);


        calendar526 = Calendar.getInstance();
        calendar526.set(Calendar.YEAR,2023);
        calendar526.set(Calendar.MONTH,4);
        calendar526.set(Calendar.DAY_OF_MONTH,26);

        calendar527 = Calendar.getInstance();
        calendar527.set(Calendar.YEAR,2023);
        calendar527.set(Calendar.MONTH,4);
        calendar527.set(Calendar.DAY_OF_MONTH,27);

        calendar528 = Calendar.getInstance();
        calendar528.set(Calendar.YEAR,2023);
        calendar528.set(Calendar.MONTH,4);
        calendar528.set(Calendar.DAY_OF_MONTH,28);

        calendar529 = Calendar.getInstance();
        calendar529.set(Calendar.YEAR,2023);
        calendar529.set(Calendar.MONTH,4);
        calendar529.set(Calendar.DAY_OF_MONTH,29);

        calendar530 = Calendar.getInstance();
        calendar530.set(Calendar.YEAR,2023);
        calendar530.set(Calendar.MONTH,4);
        calendar530.set(Calendar.DAY_OF_MONTH,30);

        calendar531 = Calendar.getInstance();
        calendar531.set(Calendar.YEAR,2023);
        calendar531.set(Calendar.MONTH,4);
        calendar531.set(Calendar.DAY_OF_MONTH,31);





        calendar601 = Calendar.getInstance();
        calendar601.set(Calendar.YEAR,2023);
        calendar601.set(Calendar.MONTH,5);
        calendar601.set(Calendar.DAY_OF_MONTH,1);

        calendar602 = Calendar.getInstance();
        calendar602.set(Calendar.YEAR,2023);
        calendar602.set(Calendar.MONTH,5);
        calendar602.set(Calendar.DAY_OF_MONTH,2);

        calendar603 = Calendar.getInstance();
        calendar603.set(Calendar.YEAR,2023);
        calendar603.set(Calendar.MONTH,5);
        calendar603.set(Calendar.DAY_OF_MONTH,3);

        calendar604 = Calendar.getInstance();
        calendar604.set(Calendar.YEAR,2023);
        calendar604.set(Calendar.MONTH,5);
        calendar604.set(Calendar.DAY_OF_MONTH,4);

        calendar605 = Calendar.getInstance();
        calendar605.set(Calendar.YEAR,2023);
        calendar605.set(Calendar.MONTH,5);
        calendar605.set(Calendar.DAY_OF_MONTH,5);

        calendar606 = Calendar.getInstance();
        calendar606.set(Calendar.YEAR,2023);
        calendar606.set(Calendar.MONTH,5);
        calendar606.set(Calendar.DAY_OF_MONTH,6);

        calendar607 = Calendar.getInstance();
        calendar607.set(Calendar.YEAR,2023);
        calendar607.set(Calendar.MONTH,5);
        calendar607.set(Calendar.DAY_OF_MONTH,7);


        calendar608 = Calendar.getInstance();
        calendar608.set(Calendar.YEAR,2023);
        calendar608.set(Calendar.MONTH,5);
        calendar608.set(Calendar.DAY_OF_MONTH,8);

        calendar609 = Calendar.getInstance();
        calendar609.set(Calendar.YEAR,2023);
        calendar609.set(Calendar.MONTH,5);
        calendar609.set(Calendar.DAY_OF_MONTH,9);

        calendar610 = Calendar.getInstance();
        calendar610.set(Calendar.YEAR,2023);
        calendar610.set(Calendar.MONTH,5);
        calendar610.set(Calendar.DAY_OF_MONTH,10);

        calendar611 = Calendar.getInstance();
        calendar611.set(Calendar.YEAR,2023);
        calendar611.set(Calendar.MONTH,5);
        calendar611.set(Calendar.DAY_OF_MONTH,11);

        calendar612 = Calendar.getInstance();
        calendar612.set(Calendar.YEAR,2023);
        calendar612.set(Calendar.MONTH,5);
        calendar612.set(Calendar.DAY_OF_MONTH,12);

        calendar613 = Calendar.getInstance();
        calendar613.set(Calendar.YEAR,2023);
        calendar613.set(Calendar.MONTH,5);
        calendar613.set(Calendar.DAY_OF_MONTH,13);

        calendar614 = Calendar.getInstance();
        calendar614.set(Calendar.YEAR,2023);
        calendar614.set(Calendar.MONTH,5);
        calendar614.set(Calendar.DAY_OF_MONTH,14);

        calendar615 = Calendar.getInstance();
        calendar615.set(Calendar.YEAR,2023);
        calendar615.set(Calendar.MONTH,5);
        calendar615.set(Calendar.DAY_OF_MONTH,15);

        calendar616 = Calendar.getInstance();
        calendar616.set(Calendar.YEAR,2023);
        calendar616.set(Calendar.MONTH,5);
        calendar616.set(Calendar.DAY_OF_MONTH,16);

        calendar617 = Calendar.getInstance();
        calendar617.set(Calendar.YEAR,2023);
        calendar617.set(Calendar.MONTH,5);
        calendar617.set(Calendar.DAY_OF_MONTH,17);


        calendar618 = Calendar.getInstance();
        calendar618.set(Calendar.YEAR,2023);
        calendar618.set(Calendar.MONTH,5);
        calendar618.set(Calendar.DAY_OF_MONTH,18);

        calendar619 = Calendar.getInstance();
        calendar619.set(Calendar.YEAR,2023);
        calendar619.set(Calendar.MONTH,5);
        calendar619.set(Calendar.DAY_OF_MONTH,19);

        calendar620 = Calendar.getInstance();
        calendar620.set(Calendar.YEAR,2023);
        calendar620.set(Calendar.MONTH,5);
        calendar620.set(Calendar.DAY_OF_MONTH,20);

        calendar621 = Calendar.getInstance();
        calendar621.set(Calendar.YEAR,2023);
        calendar621.set(Calendar.MONTH,5);
        calendar621.set(Calendar.DAY_OF_MONTH,21);

        calendar622 = Calendar.getInstance();
        calendar622.set(Calendar.YEAR,2023);
        calendar622.set(Calendar.MONTH,5);
        calendar622.set(Calendar.DAY_OF_MONTH,22);

        calendar623 = Calendar.getInstance();
        calendar623.set(Calendar.YEAR,2023);
        calendar623.set(Calendar.MONTH,5);
        calendar623.set(Calendar.DAY_OF_MONTH,23);

        calendar624 = Calendar.getInstance();
        calendar624.set(Calendar.YEAR,2023);
        calendar624.set(Calendar.MONTH,5);
        calendar624.set(Calendar.DAY_OF_MONTH,24);


        calendar625 = Calendar.getInstance();
        calendar625.set(Calendar.YEAR,2023);
        calendar625.set(Calendar.MONTH,5);
        calendar625.set(Calendar.DAY_OF_MONTH,25);


        calendar626 = Calendar.getInstance();
        calendar626.set(Calendar.YEAR,2023);
        calendar626.set(Calendar.MONTH,5);
        calendar626.set(Calendar.DAY_OF_MONTH,26);

        calendar627 = Calendar.getInstance();
        calendar627.set(Calendar.YEAR,2023);
        calendar627.set(Calendar.MONTH,5);
        calendar627.set(Calendar.DAY_OF_MONTH,27);

        calendar628 = Calendar.getInstance();
        calendar628.set(Calendar.YEAR,2023);
        calendar628.set(Calendar.MONTH,5);
        calendar628.set(Calendar.DAY_OF_MONTH,28);

        calendar629 = Calendar.getInstance();
        calendar629.set(Calendar.YEAR,2023);
        calendar629.set(Calendar.MONTH,5);
        calendar629.set(Calendar.DAY_OF_MONTH,29);

        calendar630 = Calendar.getInstance();
        calendar630.set(Calendar.YEAR,2023);
        calendar630.set(Calendar.MONTH,5);
        calendar630.set(Calendar.DAY_OF_MONTH,30);





        calendar701 = Calendar.getInstance();
        calendar701.set(Calendar.YEAR,2023);
        calendar701.set(Calendar.MONTH,6);
        calendar701.set(Calendar.DAY_OF_MONTH,1);

        calendar702 = Calendar.getInstance();
        calendar702.set(Calendar.YEAR,2023);
        calendar702.set(Calendar.MONTH,6);
        calendar702.set(Calendar.DAY_OF_MONTH,2);

        calendar703 = Calendar.getInstance();
        calendar703.set(Calendar.YEAR,2023);
        calendar703.set(Calendar.MONTH,6);
        calendar703.set(Calendar.DAY_OF_MONTH,3);

        calendar704 = Calendar.getInstance();
        calendar704.set(Calendar.YEAR,2023);
        calendar704.set(Calendar.MONTH,6);
        calendar704.set(Calendar.DAY_OF_MONTH,4);

        calendar705 = Calendar.getInstance();
        calendar705.set(Calendar.YEAR,2023);
        calendar705.set(Calendar.MONTH,6);
        calendar705.set(Calendar.DAY_OF_MONTH,5);

        calendar706 = Calendar.getInstance();
        calendar706.set(Calendar.YEAR,2023);
        calendar706.set(Calendar.MONTH,6);
        calendar706.set(Calendar.DAY_OF_MONTH,6);

        calendar707 = Calendar.getInstance();
        calendar707.set(Calendar.YEAR,2023);
        calendar707.set(Calendar.MONTH,6);
        calendar707.set(Calendar.DAY_OF_MONTH,7);


        calendar708 = Calendar.getInstance();
        calendar708.set(Calendar.YEAR,2023);
        calendar708.set(Calendar.MONTH,6);
        calendar708.set(Calendar.DAY_OF_MONTH,8);

        calendar709 = Calendar.getInstance();
        calendar709.set(Calendar.YEAR,2023);
        calendar709.set(Calendar.MONTH,6);
        calendar709.set(Calendar.DAY_OF_MONTH,9);

        calendar710 = Calendar.getInstance();
        calendar710.set(Calendar.YEAR,2023);
        calendar710.set(Calendar.MONTH,6);
        calendar710.set(Calendar.DAY_OF_MONTH,10);

        calendar711 = Calendar.getInstance();
        calendar711.set(Calendar.YEAR,2023);
        calendar711.set(Calendar.MONTH,6);
        calendar711.set(Calendar.DAY_OF_MONTH,11);

        calendar712 = Calendar.getInstance();
        calendar712.set(Calendar.YEAR,2023);
        calendar712.set(Calendar.MONTH,6);
        calendar712.set(Calendar.DAY_OF_MONTH,12);

        calendar713 = Calendar.getInstance();
        calendar713.set(Calendar.YEAR,2023);
        calendar713.set(Calendar.MONTH,6);
        calendar713.set(Calendar.DAY_OF_MONTH,13);

        calendar714 = Calendar.getInstance();
        calendar714.set(Calendar.YEAR,2023);
        calendar714.set(Calendar.MONTH,6);
        calendar714.set(Calendar.DAY_OF_MONTH,14);

        calendar715 = Calendar.getInstance();
        calendar715.set(Calendar.YEAR,2023);
        calendar715.set(Calendar.MONTH,6);
        calendar715.set(Calendar.DAY_OF_MONTH,15);

        calendar716 = Calendar.getInstance();
        calendar716.set(Calendar.YEAR,2023);
        calendar716.set(Calendar.MONTH,6);
        calendar716.set(Calendar.DAY_OF_MONTH,16);

        calendar717 = Calendar.getInstance();
        calendar717.set(Calendar.YEAR,2023);
        calendar717.set(Calendar.MONTH,6);
        calendar717.set(Calendar.DAY_OF_MONTH,17);


        calendar718 = Calendar.getInstance();
        calendar718.set(Calendar.YEAR,2023);
        calendar718.set(Calendar.MONTH,6);
        calendar718.set(Calendar.DAY_OF_MONTH,18);

        calendar719 = Calendar.getInstance();
        calendar719.set(Calendar.YEAR,2023);
        calendar719.set(Calendar.MONTH,6);
        calendar719.set(Calendar.DAY_OF_MONTH,19);

        calendar720 = Calendar.getInstance();
        calendar720.set(Calendar.YEAR,2023);
        calendar720.set(Calendar.MONTH,6);
        calendar720.set(Calendar.DAY_OF_MONTH,20);

        calendar721 = Calendar.getInstance();
        calendar721.set(Calendar.YEAR,2023);
        calendar721.set(Calendar.MONTH,6);
        calendar721.set(Calendar.DAY_OF_MONTH,21);

        calendar722 = Calendar.getInstance();
        calendar722.set(Calendar.YEAR,2023);
        calendar722.set(Calendar.MONTH,6);
        calendar722.set(Calendar.DAY_OF_MONTH,22);

        calendar723 = Calendar.getInstance();
        calendar723.set(Calendar.YEAR,2023);
        calendar723.set(Calendar.MONTH,6);
        calendar723.set(Calendar.DAY_OF_MONTH,23);

        calendar724 = Calendar.getInstance();
        calendar724.set(Calendar.YEAR,2023);
        calendar724.set(Calendar.MONTH,6);
        calendar724.set(Calendar.DAY_OF_MONTH,24);


        calendar725 = Calendar.getInstance();
        calendar725.set(Calendar.YEAR,2023);
        calendar725.set(Calendar.MONTH,6);
        calendar725.set(Calendar.DAY_OF_MONTH,25);


        calendar726 = Calendar.getInstance();
        calendar726.set(Calendar.YEAR,2023);
        calendar726.set(Calendar.MONTH,6);
        calendar726.set(Calendar.DAY_OF_MONTH,26);

        calendar727 = Calendar.getInstance();
        calendar727.set(Calendar.YEAR,2023);
        calendar727.set(Calendar.MONTH,6);
        calendar727.set(Calendar.DAY_OF_MONTH,27);

        calendar728 = Calendar.getInstance();
        calendar728.set(Calendar.YEAR,2023);
        calendar728.set(Calendar.MONTH,6);
        calendar728.set(Calendar.DAY_OF_MONTH,28);

        calendar729 = Calendar.getInstance();
        calendar729.set(Calendar.YEAR,2023);
        calendar729.set(Calendar.MONTH,6);
        calendar729.set(Calendar.DAY_OF_MONTH,29);

        calendar730 = Calendar.getInstance();
        calendar730.set(Calendar.YEAR,2023);
        calendar730.set(Calendar.MONTH,6);
        calendar730.set(Calendar.DAY_OF_MONTH,30);

        calendar731 = Calendar.getInstance();
        calendar731.set(Calendar.YEAR,2023);
        calendar731.set(Calendar.MONTH,6);
        calendar731.set(Calendar.DAY_OF_MONTH,31);




        calendar801 = Calendar.getInstance();
        calendar801.set(Calendar.YEAR,2023);
        calendar801.set(Calendar.MONTH,7);
        calendar801.set(Calendar.DAY_OF_MONTH,1);

        calendar802 = Calendar.getInstance();
        calendar802.set(Calendar.YEAR,2023);
        calendar802.set(Calendar.MONTH,7);
        calendar802.set(Calendar.DAY_OF_MONTH,2);

        calendar803 = Calendar.getInstance();
        calendar803.set(Calendar.YEAR,2023);
        calendar803.set(Calendar.MONTH,7);
        calendar803.set(Calendar.DAY_OF_MONTH,3);

        calendar804 = Calendar.getInstance();
        calendar804.set(Calendar.YEAR,2023);
        calendar804.set(Calendar.MONTH,7);
        calendar804.set(Calendar.DAY_OF_MONTH,4);

        calendar805 = Calendar.getInstance();
        calendar805.set(Calendar.YEAR,2023);
        calendar805.set(Calendar.MONTH,7);
        calendar805.set(Calendar.DAY_OF_MONTH,5);

        calendar806 = Calendar.getInstance();
        calendar806.set(Calendar.YEAR,2023);
        calendar806.set(Calendar.MONTH,7);
        calendar806.set(Calendar.DAY_OF_MONTH,6);

        calendar807 = Calendar.getInstance();
        calendar807.set(Calendar.YEAR,2023);
        calendar807.set(Calendar.MONTH,7);
        calendar807.set(Calendar.DAY_OF_MONTH,7);


        calendar808 = Calendar.getInstance();
        calendar808.set(Calendar.YEAR,2023);
        calendar808.set(Calendar.MONTH,7);
        calendar808.set(Calendar.DAY_OF_MONTH,8);

        calendar809 = Calendar.getInstance();
        calendar809.set(Calendar.YEAR,2023);
        calendar809.set(Calendar.MONTH,7);
        calendar809.set(Calendar.DAY_OF_MONTH,9);

        calendar810 = Calendar.getInstance();
        calendar810.set(Calendar.YEAR,2023);
        calendar810.set(Calendar.MONTH,7);
        calendar810.set(Calendar.DAY_OF_MONTH,10);

        calendar811 = Calendar.getInstance();
        calendar811.set(Calendar.YEAR,2023);
        calendar811.set(Calendar.MONTH,7);
        calendar811.set(Calendar.DAY_OF_MONTH,11);

        calendar812 = Calendar.getInstance();
        calendar812.set(Calendar.YEAR,2023);
        calendar812.set(Calendar.MONTH,7);
        calendar812.set(Calendar.DAY_OF_MONTH,12);

        calendar813 = Calendar.getInstance();
        calendar813.set(Calendar.YEAR,2023);
        calendar813.set(Calendar.MONTH,7);
        calendar813.set(Calendar.DAY_OF_MONTH,13);

        calendar814 = Calendar.getInstance();
        calendar814.set(Calendar.YEAR,2023);
        calendar814.set(Calendar.MONTH,7);
        calendar814.set(Calendar.DAY_OF_MONTH,14);

        calendar815 = Calendar.getInstance();
        calendar815.set(Calendar.YEAR,2023);
        calendar815.set(Calendar.MONTH,7);
        calendar815.set(Calendar.DAY_OF_MONTH,15);

        calendar816 = Calendar.getInstance();
        calendar816.set(Calendar.YEAR,2023);
        calendar816.set(Calendar.MONTH,7);
        calendar816.set(Calendar.DAY_OF_MONTH,16);

        calendar817 = Calendar.getInstance();
        calendar817.set(Calendar.YEAR,2023);
        calendar817.set(Calendar.MONTH,7);
        calendar817.set(Calendar.DAY_OF_MONTH,17);


        calendar818 = Calendar.getInstance();
        calendar818.set(Calendar.YEAR,2023);
        calendar818.set(Calendar.MONTH,7);
        calendar818.set(Calendar.DAY_OF_MONTH,18);

        calendar819 = Calendar.getInstance();
        calendar819.set(Calendar.YEAR,2023);
        calendar819.set(Calendar.MONTH,7);
        calendar819.set(Calendar.DAY_OF_MONTH,19);

        calendar820 = Calendar.getInstance();
        calendar820.set(Calendar.YEAR,2023);
        calendar820.set(Calendar.MONTH,7);
        calendar820.set(Calendar.DAY_OF_MONTH,20);

        calendar821 = Calendar.getInstance();
        calendar821.set(Calendar.YEAR,2023);
        calendar821.set(Calendar.MONTH,7);
        calendar821.set(Calendar.DAY_OF_MONTH,21);

        calendar822 = Calendar.getInstance();
        calendar822.set(Calendar.YEAR,2023);
        calendar822.set(Calendar.MONTH,7);
        calendar822.set(Calendar.DAY_OF_MONTH,22);

        calendar823 = Calendar.getInstance();
        calendar823.set(Calendar.YEAR,2023);
        calendar823.set(Calendar.MONTH,7);
        calendar823.set(Calendar.DAY_OF_MONTH,23);

        calendar824 = Calendar.getInstance();
        calendar824.set(Calendar.YEAR,2023);
        calendar824.set(Calendar.MONTH,7);
        calendar824.set(Calendar.DAY_OF_MONTH,24);


        calendar825 = Calendar.getInstance();
        calendar825.set(Calendar.YEAR,2023);
        calendar825.set(Calendar.MONTH,7);
        calendar825.set(Calendar.DAY_OF_MONTH,25);


        calendar826 = Calendar.getInstance();
        calendar826.set(Calendar.YEAR,2023);
        calendar826.set(Calendar.MONTH,7);
        calendar826.set(Calendar.DAY_OF_MONTH,26);

        calendar827 = Calendar.getInstance();
        calendar827.set(Calendar.YEAR,2023);
        calendar827.set(Calendar.MONTH,7);
        calendar827.set(Calendar.DAY_OF_MONTH,27);

        calendar828 = Calendar.getInstance();
        calendar828.set(Calendar.YEAR,2023);
        calendar828.set(Calendar.MONTH,7);
        calendar828.set(Calendar.DAY_OF_MONTH,28);

        calendar829 = Calendar.getInstance();
        calendar829.set(Calendar.YEAR,2023);
        calendar829.set(Calendar.MONTH,7);
        calendar829.set(Calendar.DAY_OF_MONTH,29);

        calendar830 = Calendar.getInstance();
        calendar830.set(Calendar.YEAR,2023);
        calendar830.set(Calendar.MONTH,7);
        calendar830.set(Calendar.DAY_OF_MONTH,30);

        calendar831 = Calendar.getInstance();
        calendar831.set(Calendar.YEAR,2023);
        calendar831.set(Calendar.MONTH,7);
        calendar831.set(Calendar.DAY_OF_MONTH,31);






        calendar901 = Calendar.getInstance();
        calendar901.set(Calendar.YEAR,2023);
        calendar901.set(Calendar.MONTH,8);
        calendar901.set(Calendar.DAY_OF_MONTH,1);

        calendar902 = Calendar.getInstance();
        calendar902.set(Calendar.YEAR,2023);
        calendar902.set(Calendar.MONTH,8);
        calendar902.set(Calendar.DAY_OF_MONTH,2);

        calendar903 = Calendar.getInstance();
        calendar903.set(Calendar.YEAR,2023);
        calendar903.set(Calendar.MONTH,8);
        calendar903.set(Calendar.DAY_OF_MONTH,3);

        calendar904 = Calendar.getInstance();
        calendar904.set(Calendar.YEAR,2023);
        calendar904.set(Calendar.MONTH,8);
        calendar904.set(Calendar.DAY_OF_MONTH,4);

        calendar905 = Calendar.getInstance();
        calendar905.set(Calendar.YEAR,2023);
        calendar905.set(Calendar.MONTH,8);
        calendar905.set(Calendar.DAY_OF_MONTH,5);

        calendar906 = Calendar.getInstance();
        calendar906.set(Calendar.YEAR,2023);
        calendar906.set(Calendar.MONTH,8);
        calendar906.set(Calendar.DAY_OF_MONTH,6);

        calendar907 = Calendar.getInstance();
        calendar907.set(Calendar.YEAR,2023);
        calendar907.set(Calendar.MONTH,8);
        calendar907.set(Calendar.DAY_OF_MONTH,7);


        calendar908 = Calendar.getInstance();
        calendar908.set(Calendar.YEAR,2023);
        calendar908.set(Calendar.MONTH,8);
        calendar908.set(Calendar.DAY_OF_MONTH,8);

        calendar909 = Calendar.getInstance();
        calendar909.set(Calendar.YEAR,2023);
        calendar909.set(Calendar.MONTH,8);
        calendar909.set(Calendar.DAY_OF_MONTH,9);

        calendar910 = Calendar.getInstance();
        calendar910.set(Calendar.YEAR,2023);
        calendar910.set(Calendar.MONTH,8);
        calendar910.set(Calendar.DAY_OF_MONTH,10);

        calendar911 = Calendar.getInstance();
        calendar911.set(Calendar.YEAR,2023);
        calendar911.set(Calendar.MONTH,8);
        calendar911.set(Calendar.DAY_OF_MONTH,11);

        calendar912 = Calendar.getInstance();
        calendar912.set(Calendar.YEAR,2023);
        calendar912.set(Calendar.MONTH,8);
        calendar912.set(Calendar.DAY_OF_MONTH,12);

        calendar913 = Calendar.getInstance();
        calendar913.set(Calendar.YEAR,2023);
        calendar913.set(Calendar.MONTH,8);
        calendar913.set(Calendar.DAY_OF_MONTH,13);

        calendar914 = Calendar.getInstance();
        calendar914.set(Calendar.YEAR,2023);
        calendar914.set(Calendar.MONTH,8);
        calendar914.set(Calendar.DAY_OF_MONTH,14);

        calendar915 = Calendar.getInstance();
        calendar915.set(Calendar.YEAR,2023);
        calendar915.set(Calendar.MONTH,8);
        calendar915.set(Calendar.DAY_OF_MONTH,15);

        calendar916 = Calendar.getInstance();
        calendar916.set(Calendar.YEAR,2023);
        calendar916.set(Calendar.MONTH,8);
        calendar916.set(Calendar.DAY_OF_MONTH,16);

        calendar917 = Calendar.getInstance();
        calendar917.set(Calendar.YEAR,2023);
        calendar917.set(Calendar.MONTH,8);
        calendar917.set(Calendar.DAY_OF_MONTH,17);


        calendar918 = Calendar.getInstance();
        calendar918.set(Calendar.YEAR,2023);
        calendar918.set(Calendar.MONTH,8);
        calendar918.set(Calendar.DAY_OF_MONTH,18);

        calendar919 = Calendar.getInstance();
        calendar919.set(Calendar.YEAR,2023);
        calendar919.set(Calendar.MONTH,8);
        calendar919.set(Calendar.DAY_OF_MONTH,19);

        calendar920 = Calendar.getInstance();
        calendar920.set(Calendar.YEAR,2023);
        calendar920.set(Calendar.MONTH,8);
        calendar920.set(Calendar.DAY_OF_MONTH,20);

        calendar921 = Calendar.getInstance();
        calendar921.set(Calendar.YEAR,2023);
        calendar921.set(Calendar.MONTH,8);
        calendar921.set(Calendar.DAY_OF_MONTH,21);

        calendar922 = Calendar.getInstance();
        calendar922.set(Calendar.YEAR,2023);
        calendar922.set(Calendar.MONTH,8);
        calendar922.set(Calendar.DAY_OF_MONTH,22);

        calendar923 = Calendar.getInstance();
        calendar923.set(Calendar.YEAR,2023);
        calendar923.set(Calendar.MONTH,8);
        calendar923.set(Calendar.DAY_OF_MONTH,23);

        calendar924 = Calendar.getInstance();
        calendar924.set(Calendar.YEAR,2023);
        calendar924.set(Calendar.MONTH,8);
        calendar924.set(Calendar.DAY_OF_MONTH,24);


        calendar925 = Calendar.getInstance();
        calendar925.set(Calendar.YEAR,2023);
        calendar925.set(Calendar.MONTH,8);
        calendar925.set(Calendar.DAY_OF_MONTH,25);


        calendar926 = Calendar.getInstance();
        calendar926.set(Calendar.YEAR,2023);
        calendar926.set(Calendar.MONTH,8);
        calendar926.set(Calendar.DAY_OF_MONTH,26);

        calendar927 = Calendar.getInstance();
        calendar927.set(Calendar.YEAR,2023);
        calendar927.set(Calendar.MONTH,8);
        calendar927.set(Calendar.DAY_OF_MONTH,27);

        calendar928 = Calendar.getInstance();
        calendar928.set(Calendar.YEAR,2023);
        calendar928.set(Calendar.MONTH,8);
        calendar928.set(Calendar.DAY_OF_MONTH,28);

        calendar929 = Calendar.getInstance();
        calendar929.set(Calendar.YEAR,2023);
        calendar929.set(Calendar.MONTH,8);
        calendar929.set(Calendar.DAY_OF_MONTH,29);

        calendar930 = Calendar.getInstance();
        calendar930.set(Calendar.YEAR,2023);
        calendar930.set(Calendar.MONTH,8);
        calendar930.set(Calendar.DAY_OF_MONTH,30);


//      tv_month.setText(DateUtil.getDate(calendarNow));

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
//        i = 28;
        MatchDate matchDate = new MatchDate();
        String d = DateUtil.getDate(calendarNow);
        i = matchDate.judge(d);
        tl.getTabAt(i).select();

    }

    public int getTabCount() {
        return tabs.size();
    }

    public TabLayout.Tab getTabAtNEW(int index) {
        return (index < 0 || index >= getTabCount()) ? null : tabs.get(index);
    }

    //    初始化翻页视图
    public void initYearFragmentData() {

        fragmentListDay = new ArrayList<>();
//        Calendar c = Calendar.getInstance();

        EveryDayFragment fragment501 = EveryDayFragment.newInstance(DateUtil.getDate(calendar501));
        EveryDayFragment fragment502 = EveryDayFragment.newInstance(DateUtil.getDate(calendar502));
        EveryDayFragment fragment503 = EveryDayFragment.newInstance(DateUtil.getDate(calendar503));
        EveryDayFragment fragment504 = EveryDayFragment.newInstance(DateUtil.getDate(calendar504));
        EveryDayFragment fragment505 = EveryDayFragment.newInstance(DateUtil.getDate(calendar505));
        EveryDayFragment fragment506 = EveryDayFragment.newInstance(DateUtil.getDate(calendar506));
        EveryDayFragment fragment507 = EveryDayFragment.newInstance(DateUtil.getDate(calendar507));
        EveryDayFragment fragment508 = EveryDayFragment.newInstance(DateUtil.getDate(calendar508));
        EveryDayFragment fragment509 = EveryDayFragment.newInstance(DateUtil.getDate(calendar509));
        EveryDayFragment fragment510 = EveryDayFragment.newInstance(DateUtil.getDate(calendar510));
        EveryDayFragment fragment511 = EveryDayFragment.newInstance(DateUtil.getDate(calendar511));
        EveryDayFragment fragment512 = EveryDayFragment.newInstance(DateUtil.getDate(calendar512));
        EveryDayFragment fragment513 = EveryDayFragment.newInstance(DateUtil.getDate(calendar513));
        EveryDayFragment fragment514 = EveryDayFragment.newInstance(DateUtil.getDate(calendar514));
        EveryDayFragment fragment515 = EveryDayFragment.newInstance(DateUtil.getDate(calendar515));
        EveryDayFragment fragment516 = EveryDayFragment.newInstance(DateUtil.getDate(calendar516));
        EveryDayFragment fragment517 = EveryDayFragment.newInstance(DateUtil.getDate(calendar517));
        EveryDayFragment fragment518 = EveryDayFragment.newInstance(DateUtil.getDate(calendar518));
        EveryDayFragment fragment519 = EveryDayFragment.newInstance(DateUtil.getDate(calendar519));
        EveryDayFragment fragment520 = EveryDayFragment.newInstance(DateUtil.getDate(calendar520));
        EveryDayFragment fragment521 = EveryDayFragment.newInstance(DateUtil.getDate(calendar521));
        EveryDayFragment fragment522 = EveryDayFragment.newInstance(DateUtil.getDate(calendar522));
        EveryDayFragment fragment523 = EveryDayFragment.newInstance(DateUtil.getDate(calendar523));
        EveryDayFragment fragment524 = EveryDayFragment.newInstance(DateUtil.getDate(calendar524));
        EveryDayFragment fragment525 = EveryDayFragment.newInstance(DateUtil.getDate(calendar525));
        EveryDayFragment fragment526 = EveryDayFragment.newInstance(DateUtil.getDate(calendar526));
        EveryDayFragment fragment527 = EveryDayFragment.newInstance(DateUtil.getDate(calendar527));
        EveryDayFragment fragment528 = EveryDayFragment.newInstance(DateUtil.getDate(calendar528));
        EveryDayFragment fragment529 = EveryDayFragment.newInstance(DateUtil.getDate(calendar529));
        EveryDayFragment fragment530 = EveryDayFragment.newInstance(DateUtil.getDate(calendar530));
        EveryDayFragment fragment531 = EveryDayFragment.newInstance(DateUtil.getDate(calendar531));



        EveryDayFragment fragment601 = EveryDayFragment.newInstance(DateUtil.getDate(calendar601));
        EveryDayFragment fragment602 = EveryDayFragment.newInstance(DateUtil.getDate(calendar602));
        EveryDayFragment fragment603 = EveryDayFragment.newInstance(DateUtil.getDate(calendar603));
        EveryDayFragment fragment604 = EveryDayFragment.newInstance(DateUtil.getDate(calendar604));
        EveryDayFragment fragment605 = EveryDayFragment.newInstance(DateUtil.getDate(calendar605));
        EveryDayFragment fragment606 = EveryDayFragment.newInstance(DateUtil.getDate(calendar606));
        EveryDayFragment fragment607 = EveryDayFragment.newInstance(DateUtil.getDate(calendar607));
        EveryDayFragment fragment608 = EveryDayFragment.newInstance(DateUtil.getDate(calendar608));
        EveryDayFragment fragment609 = EveryDayFragment.newInstance(DateUtil.getDate(calendar609));
        EveryDayFragment fragment610 = EveryDayFragment.newInstance(DateUtil.getDate(calendar610));
        EveryDayFragment fragment611 = EveryDayFragment.newInstance(DateUtil.getDate(calendar611));
        EveryDayFragment fragment612 = EveryDayFragment.newInstance(DateUtil.getDate(calendar612));
        EveryDayFragment fragment613 = EveryDayFragment.newInstance(DateUtil.getDate(calendar613));
        EveryDayFragment fragment614 = EveryDayFragment.newInstance(DateUtil.getDate(calendar614));
        EveryDayFragment fragment615 = EveryDayFragment.newInstance(DateUtil.getDate(calendar615));
        EveryDayFragment fragment616 = EveryDayFragment.newInstance(DateUtil.getDate(calendar616));
        EveryDayFragment fragment617 = EveryDayFragment.newInstance(DateUtil.getDate(calendar617));
        EveryDayFragment fragment618 = EveryDayFragment.newInstance(DateUtil.getDate(calendar618));
        EveryDayFragment fragment619 = EveryDayFragment.newInstance(DateUtil.getDate(calendar619));
        EveryDayFragment fragment620 = EveryDayFragment.newInstance(DateUtil.getDate(calendar620));
        EveryDayFragment fragment621 = EveryDayFragment.newInstance(DateUtil.getDate(calendar621));
        EveryDayFragment fragment622 = EveryDayFragment.newInstance(DateUtil.getDate(calendar622));
        EveryDayFragment fragment623 = EveryDayFragment.newInstance(DateUtil.getDate(calendar623));
        EveryDayFragment fragment624 = EveryDayFragment.newInstance(DateUtil.getDate(calendar624));
        EveryDayFragment fragment625 = EveryDayFragment.newInstance(DateUtil.getDate(calendar625));
        EveryDayFragment fragment626 = EveryDayFragment.newInstance(DateUtil.getDate(calendar626));
        EveryDayFragment fragment627 = EveryDayFragment.newInstance(DateUtil.getDate(calendar627));
        EveryDayFragment fragment628 = EveryDayFragment.newInstance(DateUtil.getDate(calendar628));
        EveryDayFragment fragment629 = EveryDayFragment.newInstance(DateUtil.getDate(calendar629));
        EveryDayFragment fragment630 = EveryDayFragment.newInstance(DateUtil.getDate(calendar630));




        EveryDayFragment fragment701 = EveryDayFragment.newInstance(DateUtil.getDate(calendar701));
        EveryDayFragment fragment702 = EveryDayFragment.newInstance(DateUtil.getDate(calendar702));
        EveryDayFragment fragment703 = EveryDayFragment.newInstance(DateUtil.getDate(calendar703));
        EveryDayFragment fragment704 = EveryDayFragment.newInstance(DateUtil.getDate(calendar704));
        EveryDayFragment fragment705 = EveryDayFragment.newInstance(DateUtil.getDate(calendar705));
        EveryDayFragment fragment706 = EveryDayFragment.newInstance(DateUtil.getDate(calendar706));
        EveryDayFragment fragment707 = EveryDayFragment.newInstance(DateUtil.getDate(calendar707));
        EveryDayFragment fragment708 = EveryDayFragment.newInstance(DateUtil.getDate(calendar708));
        EveryDayFragment fragment709 = EveryDayFragment.newInstance(DateUtil.getDate(calendar709));
        EveryDayFragment fragment710 = EveryDayFragment.newInstance(DateUtil.getDate(calendar710));
        EveryDayFragment fragment711 = EveryDayFragment.newInstance(DateUtil.getDate(calendar711));
        EveryDayFragment fragment712 = EveryDayFragment.newInstance(DateUtil.getDate(calendar712));
        EveryDayFragment fragment713 = EveryDayFragment.newInstance(DateUtil.getDate(calendar713));
        EveryDayFragment fragment714 = EveryDayFragment.newInstance(DateUtil.getDate(calendar714));
        EveryDayFragment fragment715 = EveryDayFragment.newInstance(DateUtil.getDate(calendar715));
        EveryDayFragment fragment716 = EveryDayFragment.newInstance(DateUtil.getDate(calendar716));
        EveryDayFragment fragment717 = EveryDayFragment.newInstance(DateUtil.getDate(calendar717));
        EveryDayFragment fragment718 = EveryDayFragment.newInstance(DateUtil.getDate(calendar718));
        EveryDayFragment fragment719 = EveryDayFragment.newInstance(DateUtil.getDate(calendar719));
        EveryDayFragment fragment720 = EveryDayFragment.newInstance(DateUtil.getDate(calendar720));
        EveryDayFragment fragment721 = EveryDayFragment.newInstance(DateUtil.getDate(calendar721));
        EveryDayFragment fragment722 = EveryDayFragment.newInstance(DateUtil.getDate(calendar722));
        EveryDayFragment fragment723 = EveryDayFragment.newInstance(DateUtil.getDate(calendar723));
        EveryDayFragment fragment724 = EveryDayFragment.newInstance(DateUtil.getDate(calendar724));
        EveryDayFragment fragment725 = EveryDayFragment.newInstance(DateUtil.getDate(calendar725));
        EveryDayFragment fragment726 = EveryDayFragment.newInstance(DateUtil.getDate(calendar726));
        EveryDayFragment fragment727 = EveryDayFragment.newInstance(DateUtil.getDate(calendar727));
        EveryDayFragment fragment728 = EveryDayFragment.newInstance(DateUtil.getDate(calendar728));
        EveryDayFragment fragment729 = EveryDayFragment.newInstance(DateUtil.getDate(calendar729));
        EveryDayFragment fragment730 = EveryDayFragment.newInstance(DateUtil.getDate(calendar730));
        EveryDayFragment fragment731 = EveryDayFragment.newInstance(DateUtil.getDate(calendar731));




        EveryDayFragment fragment801 = EveryDayFragment.newInstance(DateUtil.getDate(calendar801));
        EveryDayFragment fragment802 = EveryDayFragment.newInstance(DateUtil.getDate(calendar802));
        EveryDayFragment fragment803 = EveryDayFragment.newInstance(DateUtil.getDate(calendar803));
        EveryDayFragment fragment804 = EveryDayFragment.newInstance(DateUtil.getDate(calendar804));
        EveryDayFragment fragment805 = EveryDayFragment.newInstance(DateUtil.getDate(calendar805));
        EveryDayFragment fragment806 = EveryDayFragment.newInstance(DateUtil.getDate(calendar806));
        EveryDayFragment fragment807 = EveryDayFragment.newInstance(DateUtil.getDate(calendar807));
        EveryDayFragment fragment808 = EveryDayFragment.newInstance(DateUtil.getDate(calendar808));
        EveryDayFragment fragment809 = EveryDayFragment.newInstance(DateUtil.getDate(calendar809));
        EveryDayFragment fragment810 = EveryDayFragment.newInstance(DateUtil.getDate(calendar810));
        EveryDayFragment fragment811 = EveryDayFragment.newInstance(DateUtil.getDate(calendar811));
        EveryDayFragment fragment812 = EveryDayFragment.newInstance(DateUtil.getDate(calendar812));
        EveryDayFragment fragment813 = EveryDayFragment.newInstance(DateUtil.getDate(calendar813));
        EveryDayFragment fragment814 = EveryDayFragment.newInstance(DateUtil.getDate(calendar814));
        EveryDayFragment fragment815 = EveryDayFragment.newInstance(DateUtil.getDate(calendar815));
        EveryDayFragment fragment816 = EveryDayFragment.newInstance(DateUtil.getDate(calendar816));
        EveryDayFragment fragment817 = EveryDayFragment.newInstance(DateUtil.getDate(calendar817));
        EveryDayFragment fragment818 = EveryDayFragment.newInstance(DateUtil.getDate(calendar818));
        EveryDayFragment fragment819 = EveryDayFragment.newInstance(DateUtil.getDate(calendar819));
        EveryDayFragment fragment820 = EveryDayFragment.newInstance(DateUtil.getDate(calendar820));
        EveryDayFragment fragment821 = EveryDayFragment.newInstance(DateUtil.getDate(calendar821));
        EveryDayFragment fragment822 = EveryDayFragment.newInstance(DateUtil.getDate(calendar822));
        EveryDayFragment fragment823 = EveryDayFragment.newInstance(DateUtil.getDate(calendar823));
        EveryDayFragment fragment824 = EveryDayFragment.newInstance(DateUtil.getDate(calendar824));
        EveryDayFragment fragment825 = EveryDayFragment.newInstance(DateUtil.getDate(calendar825));
        EveryDayFragment fragment826 = EveryDayFragment.newInstance(DateUtil.getDate(calendar826));
        EveryDayFragment fragment827 = EveryDayFragment.newInstance(DateUtil.getDate(calendar827));
        EveryDayFragment fragment828 = EveryDayFragment.newInstance(DateUtil.getDate(calendar828));
        EveryDayFragment fragment829 = EveryDayFragment.newInstance(DateUtil.getDate(calendar829));
        EveryDayFragment fragment830 = EveryDayFragment.newInstance(DateUtil.getDate(calendar830));
        EveryDayFragment fragment831 = EveryDayFragment.newInstance(DateUtil.getDate(calendar831));




        EveryDayFragment fragment901 = EveryDayFragment.newInstance(DateUtil.getDate(calendar901));
        EveryDayFragment fragment902 = EveryDayFragment.newInstance(DateUtil.getDate(calendar902));
        EveryDayFragment fragment903 = EveryDayFragment.newInstance(DateUtil.getDate(calendar903));
        EveryDayFragment fragment904 = EveryDayFragment.newInstance(DateUtil.getDate(calendar904));
        EveryDayFragment fragment905 = EveryDayFragment.newInstance(DateUtil.getDate(calendar905));
        EveryDayFragment fragment906 = EveryDayFragment.newInstance(DateUtil.getDate(calendar906));
        EveryDayFragment fragment907 = EveryDayFragment.newInstance(DateUtil.getDate(calendar907));
        EveryDayFragment fragment908 = EveryDayFragment.newInstance(DateUtil.getDate(calendar908));
        EveryDayFragment fragment909 = EveryDayFragment.newInstance(DateUtil.getDate(calendar909));
        EveryDayFragment fragment910 = EveryDayFragment.newInstance(DateUtil.getDate(calendar910));
        EveryDayFragment fragment911 = EveryDayFragment.newInstance(DateUtil.getDate(calendar911));
        EveryDayFragment fragment912 = EveryDayFragment.newInstance(DateUtil.getDate(calendar912));
        EveryDayFragment fragment913 = EveryDayFragment.newInstance(DateUtil.getDate(calendar913));
        EveryDayFragment fragment914 = EveryDayFragment.newInstance(DateUtil.getDate(calendar914));
        EveryDayFragment fragment915 = EveryDayFragment.newInstance(DateUtil.getDate(calendar915));
        EveryDayFragment fragment916 = EveryDayFragment.newInstance(DateUtil.getDate(calendar916));
        EveryDayFragment fragment917 = EveryDayFragment.newInstance(DateUtil.getDate(calendar917));
        EveryDayFragment fragment918 = EveryDayFragment.newInstance(DateUtil.getDate(calendar918));
        EveryDayFragment fragment919 = EveryDayFragment.newInstance(DateUtil.getDate(calendar919));
        EveryDayFragment fragment920 = EveryDayFragment.newInstance(DateUtil.getDate(calendar920));
        EveryDayFragment fragment921 = EveryDayFragment.newInstance(DateUtil.getDate(calendar921));
        EveryDayFragment fragment922 = EveryDayFragment.newInstance(DateUtil.getDate(calendar922));
        EveryDayFragment fragment923 = EveryDayFragment.newInstance(DateUtil.getDate(calendar923));
        EveryDayFragment fragment924 = EveryDayFragment.newInstance(DateUtil.getDate(calendar924));
        EveryDayFragment fragment925 = EveryDayFragment.newInstance(DateUtil.getDate(calendar925));
        EveryDayFragment fragment926 = EveryDayFragment.newInstance(DateUtil.getDate(calendar926));
        EveryDayFragment fragment927 = EveryDayFragment.newInstance(DateUtil.getDate(calendar927));
        EveryDayFragment fragment928 = EveryDayFragment.newInstance(DateUtil.getDate(calendar928));
        EveryDayFragment fragment929 = EveryDayFragment.newInstance(DateUtil.getDate(calendar929));
        EveryDayFragment fragment930 = EveryDayFragment.newInstance(DateUtil.getDate(calendar930));


        fragmentListDay.add(fragment501);
        fragmentListDay.add(fragment502);
        fragmentListDay.add(fragment503);
        fragmentListDay.add(fragment504);
        fragmentListDay.add(fragment505);
        fragmentListDay.add(fragment506);
        fragmentListDay.add(fragment507);
        fragmentListDay.add(fragment508);
        fragmentListDay.add(fragment509);
        fragmentListDay.add(fragment510);
        fragmentListDay.add(fragment511);
        fragmentListDay.add(fragment512);
        fragmentListDay.add(fragment513);
        fragmentListDay.add(fragment514);
        fragmentListDay.add(fragment515);
        fragmentListDay.add(fragment516);
        fragmentListDay.add(fragment517);
        fragmentListDay.add(fragment518);
        fragmentListDay.add(fragment519);
        fragmentListDay.add(fragment520);
        fragmentListDay.add(fragment521);
        fragmentListDay.add(fragment522);
        fragmentListDay.add(fragment523);
        fragmentListDay.add(fragment524);
        fragmentListDay.add(fragment525);
        fragmentListDay.add(fragment526);
        fragmentListDay.add(fragment527);
        fragmentListDay.add(fragment528);
        fragmentListDay.add(fragment529);
        fragmentListDay.add(fragment530);
        fragmentListDay.add(fragment531);


        fragmentListDay.add(fragment601);
        fragmentListDay.add(fragment602);
        fragmentListDay.add(fragment603);
        fragmentListDay.add(fragment604);
        fragmentListDay.add(fragment605);
        fragmentListDay.add(fragment606);
        fragmentListDay.add(fragment607);
        fragmentListDay.add(fragment608);
        fragmentListDay.add(fragment609);
        fragmentListDay.add(fragment610);
        fragmentListDay.add(fragment611);
        fragmentListDay.add(fragment612);
        fragmentListDay.add(fragment613);
        fragmentListDay.add(fragment614);
        fragmentListDay.add(fragment615);
        fragmentListDay.add(fragment616);
        fragmentListDay.add(fragment617);
        fragmentListDay.add(fragment618);
        fragmentListDay.add(fragment619);
        fragmentListDay.add(fragment620);
        fragmentListDay.add(fragment621);
        fragmentListDay.add(fragment622);
        fragmentListDay.add(fragment623);
        fragmentListDay.add(fragment624);
        fragmentListDay.add(fragment625);
        fragmentListDay.add(fragment626);
        fragmentListDay.add(fragment627);
        fragmentListDay.add(fragment628);
        fragmentListDay.add(fragment629);
        fragmentListDay.add(fragment630);




        fragmentListDay.add(fragment701);
        fragmentListDay.add(fragment702);
        fragmentListDay.add(fragment703);
        fragmentListDay.add(fragment704);
        fragmentListDay.add(fragment705);
        fragmentListDay.add(fragment706);
        fragmentListDay.add(fragment707);
        fragmentListDay.add(fragment708);
        fragmentListDay.add(fragment709);
        fragmentListDay.add(fragment710);
        fragmentListDay.add(fragment711);
        fragmentListDay.add(fragment712);
        fragmentListDay.add(fragment713);
        fragmentListDay.add(fragment714);
        fragmentListDay.add(fragment715);
        fragmentListDay.add(fragment716);
        fragmentListDay.add(fragment717);
        fragmentListDay.add(fragment718);
        fragmentListDay.add(fragment719);
        fragmentListDay.add(fragment720);
        fragmentListDay.add(fragment721);
        fragmentListDay.add(fragment722);
        fragmentListDay.add(fragment723);
        fragmentListDay.add(fragment724);
        fragmentListDay.add(fragment725);
        fragmentListDay.add(fragment726);
        fragmentListDay.add(fragment727);
        fragmentListDay.add(fragment728);
        fragmentListDay.add(fragment729);
        fragmentListDay.add(fragment730);
        fragmentListDay.add(fragment731);


        fragmentListDay.add(fragment801);
        fragmentListDay.add(fragment802);
        fragmentListDay.add(fragment803);
        fragmentListDay.add(fragment804);
        fragmentListDay.add(fragment805);
        fragmentListDay.add(fragment806);
        fragmentListDay.add(fragment807);
        fragmentListDay.add(fragment808);
        fragmentListDay.add(fragment809);
        fragmentListDay.add(fragment810);
        fragmentListDay.add(fragment811);
        fragmentListDay.add(fragment812);
        fragmentListDay.add(fragment813);
        fragmentListDay.add(fragment814);
        fragmentListDay.add(fragment815);
        fragmentListDay.add(fragment816);
        fragmentListDay.add(fragment817);
        fragmentListDay.add(fragment818);
        fragmentListDay.add(fragment819);
        fragmentListDay.add(fragment820);
        fragmentListDay.add(fragment821);
        fragmentListDay.add(fragment822);
        fragmentListDay.add(fragment823);
        fragmentListDay.add(fragment824);
        fragmentListDay.add(fragment825);
        fragmentListDay.add(fragment826);
        fragmentListDay.add(fragment827);
        fragmentListDay.add(fragment828);
        fragmentListDay.add(fragment829);
        fragmentListDay.add(fragment830);
        fragmentListDay.add(fragment831);




        fragmentListDay.add(fragment901);
        fragmentListDay.add(fragment902);
        fragmentListDay.add(fragment903);
        fragmentListDay.add(fragment904);
        fragmentListDay.add(fragment905);
        fragmentListDay.add(fragment906);
        fragmentListDay.add(fragment907);
        fragmentListDay.add(fragment908);
        fragmentListDay.add(fragment909);
        fragmentListDay.add(fragment910);
        fragmentListDay.add(fragment911);
        fragmentListDay.add(fragment912);
        fragmentListDay.add(fragment913);
        fragmentListDay.add(fragment914);
        fragmentListDay.add(fragment915);
        fragmentListDay.add(fragment916);
        fragmentListDay.add(fragment917);
        fragmentListDay.add(fragment918);
        fragmentListDay.add(fragment919);
        fragmentListDay.add(fragment920);
        fragmentListDay.add(fragment921);
        fragmentListDay.add(fragment922);
        fragmentListDay.add(fragment923);
        fragmentListDay.add(fragment924);
        fragmentListDay.add(fragment925);
        fragmentListDay.add(fragment926);
        fragmentListDay.add(fragment927);
        fragmentListDay.add(fragment928);
        fragmentListDay.add(fragment929);
        fragmentListDay.add(fragment930);


        mTitleListYear = new ArrayList<>();
        mTitleListYear.add("2023-5-01");
        mTitleListYear.add("2023-5-02");
        mTitleListYear.add("2023-5-03");
        mTitleListYear.add("2023-5-04");
        mTitleListYear.add("2023-5-05");
        mTitleListYear.add("2023-5-06");
        mTitleListYear.add("2023-5-07");
        mTitleListYear.add("2023-5-08");
        mTitleListYear.add("2023-5-09");
        mTitleListYear.add("2023-5-10");
        mTitleListYear.add("2023-5-11");
        mTitleListYear.add("2023-5-12");
        mTitleListYear.add("2023-5-13");
        mTitleListYear.add("2023-5-14");
        mTitleListYear.add("2023-5-15");
        mTitleListYear.add("2023-5-16");
        mTitleListYear.add("2023-5-17");
        mTitleListYear.add("2023-5-18");
        mTitleListYear.add("2023-5-19");
        mTitleListYear.add("2023-5-20");
        mTitleListYear.add("2023-5-21");
        mTitleListYear.add("2023-5-22");
        mTitleListYear.add("2023-5-23");
        mTitleListYear.add("2023-5-24");
        mTitleListYear.add("2023-5-25");
        mTitleListYear.add("2023-5-26");
        mTitleListYear.add("2023-5-27");
        mTitleListYear.add("2023-5-28");
        mTitleListYear.add("2023-5-29");
        mTitleListYear.add("2023-5-30");
        mTitleListYear.add("2023-5-31");


        mTitleListYear.add("2023-6-01");
        mTitleListYear.add("2023-6-02");
        mTitleListYear.add("2023-6-03");
        mTitleListYear.add("2023-6-04");
        mTitleListYear.add("2023-6-05");
        mTitleListYear.add("2023-6-06");
        mTitleListYear.add("2023-6-07");
        mTitleListYear.add("2023-6-08");
        mTitleListYear.add("2023-6-09");
        mTitleListYear.add("2023-6-10");
        mTitleListYear.add("2023-6-11");
        mTitleListYear.add("2023-6-12");
        mTitleListYear.add("2023-6-13");
        mTitleListYear.add("2023-6-14");
        mTitleListYear.add("2023-6-15");
        mTitleListYear.add("2023-6-16");
        mTitleListYear.add("2023-6-17");
        mTitleListYear.add("2023-6-18");
        mTitleListYear.add("2023-6-19");
        mTitleListYear.add("2023-6-20");
        mTitleListYear.add("2023-6-21");
        mTitleListYear.add("2023-6-22");
        mTitleListYear.add("2023-6-23");
        mTitleListYear.add("2023-6-24");
        mTitleListYear.add("2023-6-25");
        mTitleListYear.add("2023-6-26");
        mTitleListYear.add("2023-6-27");
        mTitleListYear.add("2023-6-28");
        mTitleListYear.add("2023-6-29");
        mTitleListYear.add("2023-6-30");



        mTitleListYear.add("2023-7-01");
        mTitleListYear.add("2023-7-02");
        mTitleListYear.add("2023-7-03");
        mTitleListYear.add("2023-7-04");
        mTitleListYear.add("2023-7-05");
        mTitleListYear.add("2023-7-06");
        mTitleListYear.add("2023-7-07");
        mTitleListYear.add("2023-7-08");
        mTitleListYear.add("2023-7-09");
        mTitleListYear.add("2023-7-10");
        mTitleListYear.add("2023-7-11");
        mTitleListYear.add("2023-7-12");
        mTitleListYear.add("2023-7-13");
        mTitleListYear.add("2023-7-14");
        mTitleListYear.add("2023-7-15");
        mTitleListYear.add("2023-7-16");
        mTitleListYear.add("2023-7-17");
        mTitleListYear.add("2023-7-18");
        mTitleListYear.add("2023-7-19");
        mTitleListYear.add("2023-7-20");
        mTitleListYear.add("2023-7-21");
        mTitleListYear.add("2023-7-22");
        mTitleListYear.add("2023-7-23");
        mTitleListYear.add("2023-7-24");
        mTitleListYear.add("2023-7-25");
        mTitleListYear.add("2023-7-26");
        mTitleListYear.add("2023-7-27");
        mTitleListYear.add("2023-7-28");
        mTitleListYear.add("2023-7-29");
        mTitleListYear.add("2023-7-30");
        mTitleListYear.add("2023-7-31");




        mTitleListYear.add("2023-8-01");
        mTitleListYear.add("2023-8-02");
        mTitleListYear.add("2023-8-03");
        mTitleListYear.add("2023-8-04");
        mTitleListYear.add("2023-8-05");
        mTitleListYear.add("2023-8-06");
        mTitleListYear.add("2023-8-07");
        mTitleListYear.add("2023-8-08");
        mTitleListYear.add("2023-8-09");
        mTitleListYear.add("2023-8-10");
        mTitleListYear.add("2023-8-11");
        mTitleListYear.add("2023-8-12");
        mTitleListYear.add("2023-8-13");
        mTitleListYear.add("2023-8-14");
        mTitleListYear.add("2023-8-15");
        mTitleListYear.add("2023-8-16");
        mTitleListYear.add("2023-8-17");
        mTitleListYear.add("2023-8-18");
        mTitleListYear.add("2023-8-19");
        mTitleListYear.add("2023-8-20");
        mTitleListYear.add("2023-8-21");
        mTitleListYear.add("2023-8-22");
        mTitleListYear.add("2023-8-23");
        mTitleListYear.add("2023-8-24");
        mTitleListYear.add("2023-8-25");
        mTitleListYear.add("2023-8-26");
        mTitleListYear.add("2023-8-27");
        mTitleListYear.add("2023-8-28");
        mTitleListYear.add("2023-8-29");
        mTitleListYear.add("2023-8-30");
        mTitleListYear.add("2023-8-31");



        mTitleListYear.add("2023-9-01");
        mTitleListYear.add("2023-9-02");
        mTitleListYear.add("2023-9-03");
        mTitleListYear.add("2023-9-04");
        mTitleListYear.add("2023-9-05");
        mTitleListYear.add("2023-9-06");
        mTitleListYear.add("2023-9-07");
        mTitleListYear.add("2023-9-08");
        mTitleListYear.add("2023-9-09");
        mTitleListYear.add("2023-9-10");
        mTitleListYear.add("2023-9-11");
        mTitleListYear.add("2023-9-12");
        mTitleListYear.add("2023-9-13");
        mTitleListYear.add("2023-9-14");
        mTitleListYear.add("2023-9-15");
        mTitleListYear.add("2023-9-16");
        mTitleListYear.add("2023-9-17");
        mTitleListYear.add("2023-9-18");
        mTitleListYear.add("2023-9-19");
        mTitleListYear.add("2023-9-20");
        mTitleListYear.add("2023-9-21");
        mTitleListYear.add("2023-9-22");
        mTitleListYear.add("2023-9-23");
        mTitleListYear.add("2023-9-24");
        mTitleListYear.add("2023-9-25");
        mTitleListYear.add("2023-9-26");
        mTitleListYear.add("2023-9-27");
        mTitleListYear.add("2023-9-28");
        mTitleListYear.add("2023-9-29");
        mTitleListYear.add("2023-9-30");



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