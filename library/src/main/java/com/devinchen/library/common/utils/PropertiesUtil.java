package com.devinchen.library.common.utils;

import android.content.Context;

import com.devinchen.library.common.manager.UtilsManager;

import java.io.IOException;
import java.util.Properties;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.utils
 * Created by Devin Chen on 2017/5/25 14:50.
 * explain:Properties属性文件读写工具
 */

public class PropertiesUtil extends UtilsManager {
    /**
     * 读取properties文件中的变量
     *
     * @param fileName
     * @param key
     * @return
     */

    public static String load(String fileName, String key) {
        String value = null;
        Properties properties = new Properties();
        try {
            properties.load(mContext.getAssets().open(fileName));
            value = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 将变量写入属性文件
     *
     * @param fileName
     * @param key
     * @param value
     */
    public static void put(String fileName, String key, Object value) {
        Properties properties = new Properties();
        try {
            properties.load(mContext.getAssets().open(fileName));
            properties.put(key, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
