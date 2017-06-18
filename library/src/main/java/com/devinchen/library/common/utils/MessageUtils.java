package com.devinchen.library.common.utils;

import android.widget.Toast;

import com.devinchen.library.common.manager.UtilsManager;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.utils
 * Created by Devin Chen on 2017/5/15 23:05.
 * explain:toast消息弹出的工具
 */

public class MessageUtils extends UtilsManager {
    /**
     * 这里应该给app留一个初始化的接口方法，方便定制开关状态
     *
     * @return
     */
    public static boolean isDebug() {
        return mIsDebug;
    }

    /**
     * 正常显示的Toast
     *
     * @param object
     */
    public static void show(Object object) {
        Toast.makeText(mContext, String.valueOf(object), Toast.LENGTH_SHORT).show();
    }

    /**
     * 有调试控制的Toast
     *
     * @param object
     */
    public static void debug(Object object) {
        if (isDebug()) {
            show(object);
        }
    }
}
