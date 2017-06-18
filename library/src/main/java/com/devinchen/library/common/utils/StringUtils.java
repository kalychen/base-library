package com.devinchen.library.common.utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

import com.devinchen.library.common.manager.UtilsManager;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.utils
 * Created by Devin Chen on 2017/5/15 23:04.
 * explain:或字符串进行格式化处理的工具
 */

public class StringUtils extends UtilsManager {
    /**
     * 设置彩色复合文本
     *
     * @param str
     * @param color
     * @return
     */
    public static CharSequence setColourSpan(CharSequence str, int color) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        SpannableString spannableString = new SpannableString(str);
        ForegroundColorSpan span = new ForegroundColorSpan(color);
        spannableString.setSpan(span, 0, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}
