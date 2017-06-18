package com.devinchen.library.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.model
 * Created by Devin Chen on 2017/5/15 22:39.
 * explain:分页模型
 */

public class PageModel<T> {
    @SerializedName("dataCount")
    public int dataCount;
    @SerializedName("pageCount")
    public int pageCount;
    @SerializedName("page")
    public int page;
    @SerializedName("hasNext")
    public boolean hasNext;
    @SerializedName("dataList")
    public List<T> dataList;
}
