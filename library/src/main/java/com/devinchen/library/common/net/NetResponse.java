package com.devinchen.library.common.net;

import retrofit2.Call;

/**
 * CommonLibraryDemo
 * com.devinchen.commonlibrarydemo.library.net
 * Created by Devin Chen on 2017/5/14 08:54.
 * explain:
 */

public class NetResponse<T> {
    public Call<T> call;
    public boolean isSuccess;
    public T data;

    public NetResponse(Call<T> call, boolean isSuccess, T data) {
        this.call = call;
        this.isSuccess = isSuccess;
        this.data = data;
    }
}
