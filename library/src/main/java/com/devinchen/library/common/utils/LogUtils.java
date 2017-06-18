package com.devinchen.library.common.utils;

import android.util.Log;

import com.devinchen.library.common.manager.UtilsManager;

import java.util.List;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.utils
 * Created by Devin Chen on 2017/5/15 23:05.
 * explain:进行后台日志打印的工具
 */

public class LogUtils extends UtilsManager {
    public static String TAG = mContext.getPackageName();

    /**
     * 获取debug状态
     *
     * @return
     */
    public static boolean isDebug() {
        return mIsDebug;
    }

    public static void verbose(Object object) {
        Log.v(TAG, String.valueOf(object));
    }

    public static void debug(Object object) {
        Log.d(TAG, String.valueOf(object));
    }

    public static void info(Object object) {
        Log.i(TAG, String.valueOf(object));
    }

    public static void warnning(Object object) {
        Log.w(TAG, String.valueOf(object));
    }

    public static void error(Object object) {
        Log.e(TAG, String.valueOf(object));
    }

    /**
     * Log打印列表
     *
     * @param TAG
     * @param objectList
     */
    public static void printList(String TAG, List<Object> objectList) {
        if (isDebug()) {
            for (int i = 0; i < objectList.size(); i++) {
                Log.i(TAG, String.valueOf(objectList.get(i)));
            }
        }
    }

    /**
     * Log打印列表
     *
     * @param objectList
     */
    public static void printList(List objectList) {
        if (isDebug()) {
            for (int i = 0; i < objectList.size(); i++) {
                info(objectList.get(i));
            }
        }
    }

    /**
     * Log打印数组
     *
     * @param TAG
     * @param objects
     */
    public static void printArray(String TAG, Object[] objects) {
        if (isDebug()) {
            for (int i = 0; i < objects.length; i++) {
                Log.i(TAG, String.valueOf(objects[i]));
            }
        }
    }

    /**
     * Log打印数组
     *
     * @param objects
     */
    public static void printList(Object[] objects) {
        if (isDebug()) {
            for (int i = 0; i < objects.length; i++) {
                info(objects[i]);
            }
        }
    }
}
