package com.devinchen.library.common.base.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devinchen.library.common.base.activity.BaseActivity;
import com.hwangjr.rxbus.RxBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * CommonLibraryDemo
 * com.devinchen.commonlibrarydemo.library.base.fragment
 * Created by Devin Chen on 2017/5/15 00:22.
 * explain:
 */

public abstract class BaseFragment extends Fragment {
    public View contentView;
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(layoutId(), container);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        initBaseInfo();
        initInject();
        initViewAndListener();
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * 初始化基本信息
     */
    private void initBaseInfo() {

    }

    /**
     * 初始化dagger2注入器
     */
    private void initInject() {

    }

    /**
     * 初始化控件和监听器
     */
    protected abstract void initViewAndListener();

    /**
     * 布局文件
     *
     * @return
     */
    protected abstract
    @LayoutRes
    int layoutId();

    /**
     * 获取contentView
     *
     * @return
     */
    public View getContentView() {
        return contentView;
    }

    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    /**
     * 是否需要事件总线
     *
     * @return
     */
    public boolean isNeedBus() {
        return false;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isNeedBus()){
            RxBus.get().register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (isNeedBus()){
            RxBus.get().unregister(this);
        }
    }
}
