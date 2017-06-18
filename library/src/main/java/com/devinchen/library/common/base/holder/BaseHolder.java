package com.devinchen.library.common.base.holder;

import android.view.View;

import butterknife.ButterKnife;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base.holder
 * Created by Devin Chen on 2017/5/15 22:14.
 * explain:adapter中的数据持有者
 */

public class BaseHolder {
    public BaseHolder(View itemView) {
        ButterKnife.bind(this, itemView);
    }
}
