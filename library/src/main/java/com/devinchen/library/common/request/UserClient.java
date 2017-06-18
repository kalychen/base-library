package com.devinchen.library.common.request;

import com.devinchen.library.common.consts.UrlConsts;
import com.devinchen.library.common.net.NetCallback;
import com.devinchen.library.common.net.NetClient;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * CommonLibraryDemo
 * com.devinchen.commonlibrarydemo.library.request
 * Created by Devin Chen on 2017/5/14 09:13.
 * explain:接口路径
 */

public class UserClient extends NetClient implements UrlConsts {
    public static UserService service = getRetrofit(BASE_URL).create(UserService.class);


    // region user模块

    public static final String GET_USER_INFO = "getUserList";//获取用户信息

    // endregion
}
