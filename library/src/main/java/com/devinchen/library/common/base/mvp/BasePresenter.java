package com.devinchen.library.common.base.mvp;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base.mvp
 * Created by Devin Chen on 2017/5/15 22:00.
 * explain:业务逻辑 mvp专用
 */

public interface BasePresenter<View extends BaseView> {
    /**
     * 绑定View
     *
     * @param view
     */
    void bindView(View view);

    /**
     * 解绑
     */
    void unbindView();

    /**
     * 加载数据
     */
    void loadData();

    /**
     * 加载模拟数据
     * 这是应对不存在真实数据接口的情况下的权宜之计
     */
    void loadMockData();
}
