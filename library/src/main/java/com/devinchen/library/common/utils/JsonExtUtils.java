package com.devinchen.library.common.utils;

import com.devinchen.library.common.manager.BaseManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.utils
 * Created by Devin Chen on 2017/5/25 09:11.
 * explain:此类需要继承，把泛型转换成具体类
 */

public class JsonExtUtils<Model> extends BaseManager {
    public static final Gson gson = new Gson();

    //// TODO: 2017/5/25 待测试
    public List<Model> jsonToList(String jsonStr) {
        try {
            Type type = new TypeToken<List<Model>>() {
            }.getType();
            return gson.fromJson(jsonStr, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
