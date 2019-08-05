package com.speedata.highspeedtrain.people;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.speedata.highspeedtrain.R;
import com.speedata.highspeedtrain.mvp.MVPBaseActivity;
import com.speedata.highspeedtrain.peoplework.PeopleWorkActivity;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PeopleActivity extends MVPBaseActivity<PeopleContract.View, PeoplePresenter> implements PeopleContract.View {

    private EditText mEtUsertel;
    private ImageView mBtnSure;
    private Toolbar mToolbar;
    private TextView mTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        initView();
    }

    private void initView() {
        mEtUsertel = findViewById(R.id.et_usertel);
        mBtnSure = findViewById(R.id.btn_sure);
        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PeopleActivity.this, PeopleWorkActivity.class);
                startActivity(intent);
            }
        });
        mToolbar = findViewById(R.id.toolbar);
        mTv = findViewById(R.id.tv);
        mTv.setText("设置互检人员");
    }
}
