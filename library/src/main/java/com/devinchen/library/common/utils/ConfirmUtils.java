package com.devinchen.library.common.utils;

import com.devinchen.library.common.manager.UtilsManager;

import java.util.regex.Pattern;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.utils
 * Created by Devin Chen on 2017/5/15 23:08.
 * explain:数据验证工具
 */

public class ConfirmUtils extends UtilsManager {
    /**
     * 判断字符串是否符合一个手机号码
     *
     * @param number
     * @return
     */
    public static boolean isMobliePhoneNumer(String number) {
        String strExp = "^1[3,4,5,7,8]\\d{9}$";// 手机号码验证格式
        Pattern phonePattern = Pattern.compile(strExp);//验证手机号码的正则表达式
        return phonePattern.matcher(number).matches();
    }

    /**
     * 判断字符串是否邮箱地址
     *
     * @param address
     * @return
     */
    public static boolean isEmailAddress(String address) {
        String strExp = "^ $";// 邮箱格式 todo
        Pattern phonePattern = Pattern.compile(strExp);
        return phonePattern.matcher(address).matches();
    }

    /**
     * 判断字符串是否网络地址
     *
     * @param url
     * @return
     */
    public static boolean isUrl(String url) {
        String strExp = "^ $";// 网络地址格式 todo
        Pattern phonePattern = Pattern.compile(strExp);
        return phonePattern.matcher(url).matches();
    }
}
