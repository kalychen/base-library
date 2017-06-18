package com.devinchen.library.common.manager;

import android.content.Context;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.manager
 * Created by Devin Chen on 2017/5/15 22:52.
 * explain:所有管理类的父类，可以直接获取全局上下文
 */

public class BaseManager {
    public static Context mContext;
    public static boolean mIsDebug;

    /**
     * 初始化
     *
     * @param context
     */
    public static void init(Context context) {
        mContext = context;
    }

    /**
     * 设置debug状态
     *
     * @param state
     */
    public static void setDebug(boolean state) {
        mIsDebug = state;
    }

    /**
     * 开放的获取全局上下文方法
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }
}
