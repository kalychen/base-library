package com.devinchen.library.common.base.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base.holder
 * Created by Devin Chen on 2017/5/16 21:05.
 * explain:
 */

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {
    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
