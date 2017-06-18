package com.devinchen.library.common.net;

import android.util.Log;

import com.google.gson.Gson;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * CommonLibraryDemo
 * com.devinchen.commonlibrarydemo.library.net
 * Created by Devin Chen on 2017/5/14 09:08.
 * explain:
 */

public class NetApi {
    public static RequestBody postRequestBody(Map map) {
        Log.i("request json=", new Gson().toJson(map));
        return RequestBody.create(MediaType.parse("application/json"), new Gson().toJson(map));
    }
}
