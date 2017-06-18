package com.devinchen.commonlibrarydemo;

import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.devinchen.commonlibrarydemo.library.model.UserModel;
import com.devinchen.library.common.base.activity.BaseActivity;
import com.devinchen.library.common.utils.JsonUtils;

import java.util.Map;


public class MainActivity extends BaseActivity {


    private void init() {

        UserModel userModel = new UserModel();
        userModel.id = 1;
        userModel.name = "kalychen";
        userModel.age = 38;

        Map<String, Object> map = JsonUtils.toMap(userModel);
        String name = (String) map.get("name");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewAndListener() {
        init();
    }

    @Override
    protected boolean hasToolBar() {
        return true;
    }

    @Override
    protected void setupToolBar(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.drawable.ic_launcher);
        toolbar.setTitle("工具条吼吼");
    }
}
