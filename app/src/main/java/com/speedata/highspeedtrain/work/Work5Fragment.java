package com.speedata.highspeedtrain.work;


import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.speedata.highspeedtrain.BaseFragment;
import com.speedata.highspeedtrain.InfoBean;
import com.speedata.highspeedtrain.R;
import com.speedata.highspeedtrain.RVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class Work5Fragment extends BaseFragment {

    private RVAdapter mAdapter;
    private List<InfoBean> datas;
    private RecyclerView mRvContent;

    public static Work5Fragment newInstance() {
        Bundle args = new Bundle();
        Work5Fragment fragment = new Work5Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_home_zhihu;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        mRvContent = view.findViewById(R.id.rv);
        datas = new ArrayList<>();
        createData();
        mAdapter = new RVAdapter(getActivity(), R.layout.view_rv, datas);
        mRvContent.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setStackFromEnd(true);//列表再底部开始展示，反转后由上面开始展示
        layoutManager.setReverseLayout(true);//列表翻转
        mRvContent.setLayoutManager(layoutManager);
        mRvContent.setAdapter(mAdapter);
    }

    private void createData() {
        InfoBean infoBean=new InfoBean();
        infoBean.setTitle("录制音频");
        datas.add(infoBean);

        InfoBean infoBean1=new InfoBean();
        infoBean1.setTitle("录制视频");
        datas.add(infoBean1);

    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}
