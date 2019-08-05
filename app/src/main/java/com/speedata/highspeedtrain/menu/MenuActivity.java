package com.speedata.highspeedtrain.menu;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.speedata.highspeedtrain.MainActivity;
import com.speedata.highspeedtrain.R;
import com.speedata.highspeedtrain.asset.AssetActivity;
import com.speedata.highspeedtrain.help.HelpActivity;
import com.speedata.highspeedtrain.mvp.MVPBaseActivity;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MenuActivity extends MVPBaseActivity<MenuContract.View, MenuPresenter> implements MenuContract.View {

    private Button mBtnAsset;
    private Button mBtnCheck;
    private Button mBtnHelp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();
    }

    private void initView() {
        mBtnAsset = findViewById(R.id.btn_asset);
        mBtnAsset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AssetActivity.class);
                startActivity(intent);
            }
        });
        mBtnCheck = findViewById(R.id.btn_check);
        mBtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mBtnHelp = findViewById(R.id.btn_help);
        mBtnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });
    }
}
