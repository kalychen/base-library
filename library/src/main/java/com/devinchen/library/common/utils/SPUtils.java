package com.devinchen.library.common.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.devinchen.library.common.manager.UtilsManager;

import java.util.Set;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.utils
 * Created by Devin Chen on 2017/5/16 21:04.
 * explain:SharedPreferences存取工具
 */

public class SPUtils extends UtilsManager {
    public static final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

    /**
     * 保存
     *
     * @param key
     * @param value
     */
    public static void save(String key, Object value) {
        if (value instanceof Integer) {
            sharedPreferences.edit().putInt(key, (Integer) value).commit();
        } else if (value instanceof Boolean) {
            sharedPreferences.edit().putBoolean(key, (Boolean) value).commit();
        } else if (value instanceof Float) {
            sharedPreferences.edit().putFloat(key, (Float) value).commit();
        } else if (value instanceof Long) {
            sharedPreferences.edit().putLong(key, (Long) value).commit();
        } else if (value instanceof Set) {
            sharedPreferences.edit().putStringSet(key, (Set<String>) value).commit();
        } else if (value instanceof String) {
            sharedPreferences.edit().putString(key, (String) value).commit();
        }
    }

    /**
     * 读取String
     *
     * @param key
     * @param def
     * @return
     */
    public static String read(String key, String def) {
        return sharedPreferences.getString(key, def);
    }

    /**
     * 读取int
     *
     * @param key
     * @param def
     * @return
     */
    public static int readInt(String key, int def) {
        return sharedPreferences.getInt(key, def);
    }

    /**
     * 读取float
     *
     * @param key
     * @param def
     * @return
     */
    public static float readFloat(String key, float def) {
        return sharedPreferences.getFloat(key, def);
    }

    /**
     * 读取long
     *
     * @param key
     * @param def
     * @return
     */
    public static long readLong(String key, long def) {
        return sharedPreferences.getLong(key, def);
    }

    /**
     * 读取boolean
     *
     * @param key
     * @param def
     * @return
     */
    public static boolean readBoolean(String key, boolean def) {
        return sharedPreferences.getBoolean(key, def);
    }

    /**
     * 读取StringSet
     *
     * @param key
     * @param def
     * @return
     */
    public static Set<String> readStringSet(String key, Set<String> def) {
        return sharedPreferences.getStringSet(key, def);
    }

    /**
     * 删除
     *
     * @param key
     */
    public static void remove(String key) {
        sharedPreferences.edit().remove(key).commit();
    }

    /**
     * 清空
     */
    public static void clear() {
        sharedPreferences.edit().clear().commit();
    }
}
