package com.devinchen.library.common.net;

import android.util.Log;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * CommonLibraryDemo
 * com.devinchen.commonlibrarydemo.library.net
 * Created by Devin Chen on 2017/5/14 08:48.
 * explain:
 */

public abstract class NetCallback<T> implements Callback {
    public NetCallback() {
    }

    @Override
    public void onResponse(Call call, Response response) {
//        Log.i("return json=", response.body().toString());
        try {
            if (response.code() == 200) {
                NetResult<T> result = (NetResult<T>) response.body();
                Log.i("return json=", new Gson().toJson(result));
                onCpmplete(new NetResponse<T>(call, true, result.data));
            } else {
                onCpmplete(new NetResponse<T>(call, false, null));
            }
        } catch (Exception e) {
            e.printStackTrace();
            onCpmplete(new NetResponse<T>(call, false, null));
        }

    }

    @Override
    public void onFailure(Call call, Throwable t) {
        onCpmplete(new NetResponse<T>(call, false, null));
    }

    public abstract void onCpmplete(NetResponse<T> netResponse);
}
