package com.devinchen.library.common.base.mvp;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base.mvp
 * Created by Devin Chen on 2017/5/15 22:01.
 * explain:UI处理 mvcpu专用
 */

public interface BaseUi<View extends BaseView,Business extends BaseBusiness> {
    /**
     * 绑定VP
     * @param view
     * @param business
     */
    void bindVp(View view,Business business);

    /**
     * 解绑
     */
    void unbindVp();

    /**
     * 加载数据
     */
    void updateData();
}
