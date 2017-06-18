package com.devinchen.library.common.request;

import com.devinchen.library.common.net.NetApi;
import com.devinchen.library.common.net.NetCallback;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * CommonLibraryDemo
 * com.devinchen.commonlibrarydemo.library.request
 * Created by Devin Chen on 2017/5/14 09:30.
 * explain:接口
 */

public class UserApi extends NetApi {
    // region user模块

    /**
     * 获取用户信息
     *
     * @param callback
     */
    public static void getUserInfo(NetCallback<String> callback) {
        Map<String, Object> map = new HashMap<>();
//        map.put("id", 1);
        Call call = UserClient.service.getUserInfo(postRequestBody(map));
        call.enqueue(callback);
    }
    // endregion

}
