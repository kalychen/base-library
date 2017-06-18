package com.devinchen.library.common.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hwangjr.rxbus.RxBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * CommonLibraryDemo
 * com.devinchen.commonlibrarydemo.library.base.activity
 * Created by Devin Chen on 2017/5/15 00:08.
 * explain:封装Activity
 * 具有定制工具条，设置RxBus事件总线的功能
 */

public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 底层布局视图
     */
    public View contentView;

    /**
     * View注入工具
     */
    private Unbinder unbinder;
    /**
     * 工具条
     */
    protected Toolbar toolbar;
    /**
     * 工具条上的返回按钮
     */
    protected ImageView backButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeContentView();
        setupContentview();
        initStatusBar();
        initButterknife();
        initInject();
        initViewAndListener();
    }

    /**
     * 设置布局文件
     *
     * @return
     */
    public abstract
    @LayoutRes
    int layoutId();

    /**
     * 初始化控件和监听器
     */
    protected abstract void initViewAndListener();

    /**
     * 设置工具条的控件id
     * 根据这个id的返回值判断是使用自定义风格的toolBar还是默认样式
     */
    protected int toolBarId() {
        return 0;
    }

    /**
     * 返回按钮（图片）目的是找到这个控件，便于对其进行隐藏和监听
     */
    protected int backId() {
        return 0;
    }

    /**
     * 对工具条进行设置
     *
     * @param toolbar
     */
    protected void setupToolBar(Toolbar toolbar) {
    }

    /**
     * 初始化Butterknife
     */
    private void initButterknife() {
        unbinder = ButterKnife.bind(this);
    }

    /**
     * 对状态栏做沉浸式处理
     */
    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }

    /**
     * 初始化dagger2注入器
     */
    private void initInject() {

    }

    /**
     * 设置contentView之前的处理
     */
    public void beforeContentView() {
        isNeedBus();
        hasToolBar();
    }

    /**
     * 设置contentView
     */
    public void setupContentview() {
        contentView = getLayoutInflater().inflate(layoutId(), null);
        setContentView(extContentView(contentView));
        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }
    }

    /**
     * 获得contentView
     *
     * @return
     */
    public View getContentView() {
        return contentView;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isNeedBus()) {
            RxBus.get().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isNeedBus()) {
            RxBus.get().unregister(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /**
     * 是否需要事件总线
     *
     * @return
     */
    protected boolean isNeedBus() {
        return false;
    }

    /**
     * 是否有工具条
     *
     * @return
     */
    protected boolean hasToolBar() {
        return false;
    }

    /**
     * 获得工具条
     *
     * @return
     */
    public Toolbar getToolbar() {
        return toolbar;
    }

    /**
     * 给contentView加上工具条
     *
     * @param contentView
     * @return
     */
    private View extContentView(View contentView) {
        //1.判断是否需要工具条
        if (hasToolBar()) {
            //2.是否有自定义的工具条控件
            if (toolBarId() != 0) {
                //进行实例化
                toolbar = (Toolbar) View.inflate(this, toolBarId(), null);
                //3.判断是否有一个返回按钮（图片）
                if (backId() != 0) {
                    //进行实例化
                    backButton = (ImageView) toolbar.findViewById(backId());
                    //添加返回处理
                    backButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                }
                //4.如果没有自定义的工具条，则动态生成一个
            } else {
                toolbar = new Toolbar(this);
                LinearLayout.LayoutParams toolBarParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                toolbar.setLayoutParams(toolBarParams);
            }
            //5.把toolBar和原来的布局组合到一个线性布局当中
            LinearLayout layout = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layout.setLayoutParams(params);
            layout.setOrientation(LinearLayout.VERTICAL);//垂直方向
            layout.addView(toolbar);//添加工具条
            layout.addView(contentView);//添加原来的视图

            setupToolBar(toolbar);//设置工具条

            return layout;//返回处理好的view
        }
        //返回原来的view
        return contentView;
    }

    /**
     * 启动另一个Activity
     * @param activity
     */
    public void startActivity(Activity activity) {
        startActivity(new Intent(this, activity.getClass()));
    }

    /**
     * 启动另一个Activity
     * @param activity
     * @param bundle
     */
    public void startActivity(Activity activity, Bundle bundle) {
        Intent intent = new Intent(this, activity.getClass());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 启动另一个Activity,并且结束自己
     * @param activity
     */
    public void toActivity(Activity activity) {
        startActivity(activity);
        finish();
    }

    /**
     * 启动另一个Activity,并且结束自己
     * @param activity
     * @param bundle
     */
    public void toActivity(Activity activity, Bundle bundle) {
       startActivity(activity, bundle);
        finish();
    }
}
