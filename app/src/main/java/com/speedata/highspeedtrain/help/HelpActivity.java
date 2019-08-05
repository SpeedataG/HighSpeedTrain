package com.speedata.highspeedtrain.help;


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

public class HelpActivity extends MVPBaseActivity<HelpContract.View, HelpPresenter>
        implements HelpContract.View,View.OnClickListener {


    private Button mBtnData;
    private Button mBtnMsg;
    private Button mBtnReplace;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        initView();
    }

    private void initView() {
        mBtnData = findViewById(R.id.btn_data);
        mBtnData.setOnClickListener(this);
        mBtnMsg = findViewById(R.id.btn_msg);
        mBtnMsg.setOnClickListener(this);
        mBtnReplace = findViewById(R.id.btn_replace);
        mBtnReplace.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_data:
                Toast.makeText(this, "正在开发中...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_msg:
                Toast.makeText(this, "正在开发中...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_replace:
                Toast.makeText(this, "正在开发中...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
