package com.speedata.highspeedtrain.peoplework;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.speedata.highspeedtrain.BaseActivity;
import com.speedata.highspeedtrain.R;

/**
 * Created by 张明_ on 2018/5/4.
 * Email 741183142@qq.com
 */

public class PeopleWorkActivity extends BaseActivity {

    private Toolbar mToolbar;
    private android.widget.TextView mTv;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_work;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
//        mToolbar = findViewById(R.id.toolbar);
//        mToolbar.setTitle("");
//        mTv = findViewById(R.id.tv);
//        mTv.setText("工作");
    }

    @Override
    public void doBusiness() {
        setDefaultFragment();
    }

    @Override
    public void onWidgetClick(View view) {

    }

    /**
     * 设置默认的Fragment
     */
    private void setDefaultFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_container, new PeopleWorkFragment());
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
        getSupportFragmentManager().executePendingTransactions();
    }
}
