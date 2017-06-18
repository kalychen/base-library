package com.devinchen.library.common.base.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base.adapter
 * Created by Devin Chen on 2017/5/25 11:02.
 * explain:
 */

public abstract class BasePagerAdapter extends PagerAdapter {
    public List<View> viewList;

    public BasePagerAdapter() {
    }

    public BasePagerAdapter(List<View> viewList) {
        this.viewList = viewList;
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        View childView = getItem(position);
        container.addView(childView);
        return childView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 获得一个子页面
     *
     * @param position
     * @return
     */
    public View getItem(int position) {
        return viewList.get(position);
    }

    /**
     * 更新页面
     *
     * @param viewList
     */
    public void updatePages(List<View> viewList) {
        this.viewList = viewList;
        notifyDataSetChanged();
    }
}
