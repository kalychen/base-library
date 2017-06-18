package com.devinchen.library.common.base.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devinchen.library.common.base.holder.BaseRecyclerViewHolder;

import java.util.List;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base.adapter
 * Created by Devin Chen on 2017/5/16 21:05.
 * explain:
 */

public abstract class BaseRecyclerViewAdapter<DataSet, Model, Holder extends BaseRecyclerViewHolder> extends RecyclerView.Adapter {
    public Context context;
    public DataSet mData;
    public View itemView;
    private OnItemClickListener onItemClickListener;

    public BaseRecyclerViewAdapter(Context context) {
        this(context, null);
    }

    public BaseRecyclerViewAdapter(Context context, DataSet mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        itemView = LayoutInflater.from(this.context).inflate(itemLayoutId(), parent, false);
        return createHolder(itemView);
    }

    /**
     * 项目布局
     *
     * @return
     */
    protected abstract
    @LayoutRes
    int itemLayoutId();

    /**
     * 创建holder
     *
     * @param itemView
     * @return
     */
    protected abstract Holder createHolder(View itemView);

    /**
     * 为控件填充数据
     *
     * @param holder
     * @param position
     */
    protected abstract void refreshView(Holder holder, int position);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (onItemClickListener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view, position);
                }
            });
        }
        refreshView((Holder) holder, position);
    }

    /**
     * 获得数据总数
     *
     * @return
     */
    @Override
    public int getItemCount() {
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

    /**
     * 获得列表项的数据
     *
     * @param position
     * @return
     */
    public Model getItem(int position) {
        if (mData == null) {
            return null;
        } else {
            if (mData instanceof List) {
                return ((List<Model>) mData).get(position);
            } else {
                return ((Model[]) mData)[position];
            }
        }
    }

    /**
     * 更新数据
     *
     * @param mData
     */
    public void updateData(DataSet mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    /**
     * 获取数据集
     *
     * @return
     */
    public DataSet getDataSet() {
        return mData;
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
