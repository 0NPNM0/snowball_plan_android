package com.example.snowball_plan.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class MonthFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragmentList;
    private final List<String> mTitleList;
    private final FragmentManager mfragmentManager;
    private final String year;
    private Fragment mfragmentAtPos1;

    public MonthFragmentPagerAdapter(@NonNull FragmentManager fm,
                                     List<Fragment> fragmentList,
                                     List<String> titleList,
                                     String year) {
        super(fm);
        this.mfragmentManager=fm;
        this.year=year;
        this.mFragmentList = fragmentList;
        this.mTitleList = titleList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList == null ? null : mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList == null ? "" : mTitleList.get(position);
    }

}
