package com.devinchen.library.common.base;

import android.support.multidex.MultiDexApplication;

import com.devinchen.library.common.manager.BaseManager;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base
 * Created by Devin Chen on 2017/5/25 08:31.
 * explain:在清单文件中，应该首先添加这个类的继承类.如：
 * android:name=".library.base.BaseApp"
 */

public abstract class BaseApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        BaseManager.init(getApplicationContext());
        initApp();
    }

    /**
     * App的初始化工作
     */
    protected abstract void initApp();
}
