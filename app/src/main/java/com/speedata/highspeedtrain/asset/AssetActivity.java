package com.speedata.highspeedtrain.asset;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.speedata.highspeedtrain.R;
import com.speedata.highspeedtrain.mvp.MVPBaseActivity;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AssetActivity extends MVPBaseActivity<AssetContract.View, AssetPresenter>
        implements AssetContract.View, View.OnClickListener {

    private Button mBtnWrite;
    private Button mBtnRelevance;
    private Button mBtnManage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset);
        initView();
    }

    private void initView() {
        mBtnWrite = findViewById(R.id.btn_write);
        mBtnWrite.setOnClickListener(this);
        mBtnRelevance = findViewById(R.id.btn_relevance);
        mBtnRelevance.setOnClickListener(this);
        mBtnManage = findViewById(R.id.btn_manage);
        mBtnManage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_write:
                Toast.makeText(this, "正在开发中...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_relevance:
                Toast.makeText(this, "正在开发中...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_manage:
                Toast.makeText(this, "正在开发中...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
