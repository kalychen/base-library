package com.devinchen.library.common.base.event;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.event
 * Created by Devin Chen on 2017/5/15 22:35.
 * explain:事件总线通信的消息封装基类
 */

public class BaseEvent<Data> {
    public static final int SUCCESS = 0x0001;//成功
    public static final int FAILURE = 0x0002;//失败
    public static final int ERROR = 0x0003;//错误

    public int code;//标记
    public String message;//消息
    public Data data;//数据
}
