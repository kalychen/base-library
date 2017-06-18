package com.devinchen.commonlibrarydemo.library.base;

import com.devinchen.library.common.base.BaseApplication;
import com.devinchen.library.common.manager.BaseManager;

/**
 * CommonLibraryDemo
 * com.devinchen.commonlibrarydemo.library.base
 * Created by Devin Chen on 2017/5/25 08:56.
 * explain:
 */

public class BaseApp extends BaseApplication {
    @Override
    protected void initApp() {
        BaseManager.setDebug(true);
    }
}
