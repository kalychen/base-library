package com.devinchen.library.common.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.devinchen.library.common.base.holder.BaseHolder;

import java.util.List;
import java.util.Random;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base.adapter
 * Created by Devin Chen on 2017/5/25 12:00.
 * explain:双布局风格的BaseAdapter
 * 要求两个布局必须具有相同的子控件，否则使用同一个holder会出错
 */

public abstract class BaseDoubleAdapter<DataSet, Model, Holder extends BaseHolder> extends BaseAdapter {
    public Context context;
    public DataSet mData;

    public BaseDoubleAdapter(Context context, DataSet mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        if (mData == null) {
            return 0;
        } else {
            if (mData instanceof List) {
                return ((List<Model>) mData).size();
            } else {
                return ((Model[]) mData).length;
            }
        }
    }

    @Override
    public Model getItem(int position) {
        if (mData instanceof List) {
            return ((List<Model>) mData).get(position);
        } else {
            return ((Model[]) mData)[position];
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 通过随机数决定该使用哪一种风格的布局
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return new Random().nextInt(10000) % 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            if (getItemViewType(position) == 0) {
                convertView = LayoutInflater.from(context).inflate(layoutFirstId(), parent, false);
            } else {
                convertView = LayoutInflater.from(context).inflate(layoutSecondId(), parent, false);
            }
            holder = createHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        refreshView(holder, position);
        return null;
    }

    /**
     * 填充数据
     *
     * @param holder
     * @param position
     */
    protected abstract void refreshView(Holder holder, int position);

    /**
     * 创建holder
     *
     * @param convertView
     * @return
     */
    protected abstract Holder createHolder(View convertView);

    /**
     * 第一种布局
     *
     * @return
     */
    protected abstract int layoutFirstId();

    /**
     * 第二种布局
     *
     * @return
     */
    protected abstract int layoutSecondId();
}
