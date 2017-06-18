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
 * Created by Devin Chen on 2017/5/25 12:01.
 * explain:多布局风格的Adapter
 * 所有布局依然是只使用一种数据，所以要求所有布局的子控件要一致
 */

public abstract class BaseMultiAdapter<DataSet, Model, Holder extends BaseHolder> extends BaseAdapter {
    public Context context;
    public DataSet mData;

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
        if (layoutIds().length != 0) {
            return new Random().nextInt(10000) % layoutIds().length;
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutIds()[getItemViewType(position)], parent, false);
            holder = createHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        refreshView(holder, position);
        return null;
    }

    /**
     * 布局的集合
     *
     * @return
     */
    protected abstract int[] layoutIds();

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
}
