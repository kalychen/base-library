package com.devinchen.library.common.request;

import com.devinchen.library.common.net.NetResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * CommonLibraryDemo
 * com.devinchen.commonlibrarydemo.library.request
 * Created by Devin Chen on 2017/5/14 09:14.
 * explain:retrofit 接口
 */

public interface UserService {

    // region user模块

    @POST(UserClient.GET_USER_INFO)//获取用户信息
    Call<NetResult<String>> getUserInfo(@Body RequestBody jsonBody);

    // endregion


}
