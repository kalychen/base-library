package com.devinchen.library.common.utils;

import com.devinchen.library.common.manager.UtilsManager;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.utils
 * Created by Devin Chen on 2017/5/15 23:00.
 * explain:尺寸测量工具
 * 主要负责尺寸单位的转换
 */

public class MeasureUtils extends UtilsManager {
    public static int dp2px(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int sp2px(float spValue) {
        final float fontScale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int px2dp(float pxValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int px2sp(float pxValue) {
        final float fontScale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }
}
