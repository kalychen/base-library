package com.devinchen.library.common.utils;

import com.devinchen.library.common.manager.UtilsManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.utils
 * Created by Devin Chen on 2017/5/16 21:12.
 * explain:json解析和打包工具
 */

public class JsonUtils extends UtilsManager {
    public static final Gson gson = new Gson();

    /**
     * 把对象转换为json字符串
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        try {
            return gson.toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把json字符串转换为对象
     *
     * @param jsonStr
     * @param clazz
     * @param <Model>
     * @return
     */
    public static <Model> Model jsonToObject(String jsonStr, Class<Model> clazz) {
        try {
            return gson.fromJson(jsonStr, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把json转换为List集合
     * 不过会有数据类型的问题
     * 如果出现基本数据类型转换问题，需要将次方法移植，把泛型换成具体的类
     * 另有一个JsonExtUtils可以可以继承，专门处理此类问题
     *
     * @param jsonStr
     * @param <Model>
     * @return
     */
    public static <Model> List<Model> jsonToList(String jsonStr) {
        try {
            Type type = new TypeToken<List<Model>>() {
            }.getType();
            return gson.fromJson(jsonStr, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把对象转换为Map
     * @param model
     * @param <Model>
     * @return
     */
    public static <Model> Map<String, Object> toMap(Model model) {
        String json = gson.toJson(model);
        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
