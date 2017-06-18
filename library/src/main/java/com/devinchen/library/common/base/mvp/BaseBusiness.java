package com.devinchen.library.common.base.mvp;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base.mvp
 * Created by Devin Chen on 2017/5/15 22:07.
 * explain:业务逻辑 mvcpu专用
 */

public interface BaseBusiness<View extends BaseView, Ui extends BaseUi> {
    /**
     * 绑定VU
     *
     * @param view
     * @param ui
     */
    void bindVu(View view, Ui ui);

    /**
     * 解绑VU
     */
    void unbindVu();

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
