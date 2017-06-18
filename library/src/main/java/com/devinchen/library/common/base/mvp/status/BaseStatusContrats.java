package com.devinchen.library.common.base.mvp.status;

import com.devinchen.library.common.base.mvp.BasePresenter;
import com.devinchen.library.common.base.mvp.BaseView;

/**
 * Created by Chris Chen on 2017/6/17.
 * 专门处理网络请求状态的MVP契约接口
 */

public interface BaseStatusContrats {
    interface View extends BaseView{}
    interface Presenter extends BasePresenter<View>{}
}
