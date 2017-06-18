package com.devinchen.library.common.base.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base.adapter
 * Created by Devin Chen on 2017/5/25 10:57.
 * explain:
 */

public class BaseFragmentAdapter extends FragmentPagerAdapter {
    public String[] titles;
    public List<Fragment> fragmentList;

    public BaseFragmentAdapter(FragmentManager fm, String[] titles, List<Fragment> fragmentList) {
        super(fm);
        this.titles = titles;
        this.fragmentList = fragmentList;
    }

    public BaseFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
