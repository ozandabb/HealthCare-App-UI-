package com.ozandabb.healthappui.Home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class sectionPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "sectionPagerAdapter";

    private final List<Fragment> mfragments = new ArrayList<>();

    public sectionPagerAdapter( FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mfragments.get(position);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }

    public void adFragment(Fragment fragment){
        mfragments.add(fragment);
    }
}
