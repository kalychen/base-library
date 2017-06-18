package com.devinchen.library.common.base.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.devinchen.library.common.base.holder.BaseHolder;

import java.util.List;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base.holder
 * Created by Devin Chen on 2017/5/15 22:16.
 * explain:ListView的适配器封装基类
 * DataSet 集合或者数组
 * Model 实体类
 * Holder BaseHolder的子类
 */

public abstract class BaseDataAdapter<DataSet, Model, Holder extends BaseHolder> extends BaseAdapter {
    public Context context;
    public DataSet mData;

    public BaseDataAdapter(Context context) {
        this(context, null);
    }

    public BaseDataAdapter(Context context, DataSet mData) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutId(), null);
            holder = createHolder();
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        bindHolder(holder, position, parent);

        return convertView;
    }

    /**
     * 绑定holder 填充数据
     *
     * @param holder
     * @param position
     * @param parent
     */
    protected abstract void bindHolder(Holder holder, int position, ViewGroup parent);

    /**
     * 创建holder
     *
     * @return
     */
    protected abstract Holder createHolder();

    /**
     * 布局文件
     *
     * @return
     */
    protected abstract
    @LayoutRes
    int layoutId();

    /**
     * 刷新数据
     *
     * @param mData
     */
    public void updateData(DataSet mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }
}
