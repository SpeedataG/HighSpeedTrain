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

public class Work2Fragment extends BaseFragment {

    private RVAdapter mAdapter;
    private List<InfoBean> datas;
    private RecyclerView mRvContent;

    public static Work2Fragment newInstance() {
        Bundle args = new Bundle();
        Work2Fragment fragment = new Work2Fragment();
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
        infoBean.setTitle("承力索偏移值静态检测记录");
        datas.add(infoBean);

        InfoBean infoBean1=new InfoBean();
        infoBean1.setTitle("接触线静态检测记录");
        datas.add(infoBean1);

        InfoBean infoBean2=new InfoBean();
        infoBean2.setTitle("电联结温度测试记录");
        datas.add(infoBean2);

        InfoBean infoBean3=new InfoBean();
        infoBean3.setTitle("分段绝缘器、分相绝缘器静态检测记录");
        datas.add(infoBean3);

        InfoBean infoBean4=new InfoBean();
        infoBean4.setTitle("1#锚段关节静态检测记录");
        datas.add(infoBean4);

        InfoBean infoBean5=new InfoBean();
        infoBean5.setTitle("2#锚段关节静态检测记录");
        datas.add(infoBean5);

        InfoBean infoBean6=new InfoBean();
        infoBean6.setTitle("3#锚段关节静态检测记录");
        datas.add(infoBean6);

        InfoBean infoBean7=new InfoBean();
        infoBean7.setTitle("1#锚段关节式电分相静态检测记录");
        datas.add(infoBean7);

        InfoBean infoBean8=new InfoBean();
        infoBean8.setTitle("2#锚段关节式电分相静态检测记录");
        datas.add(infoBean8);

        InfoBean infoBean9=new InfoBean();
        infoBean9.setTitle("3#锚段关节式电分相静态检测记录");
        datas.add(infoBean9);

        InfoBean infoBean10=new InfoBean();
        infoBean10.setTitle("交叉线静态检测记录");
        datas.add(infoBean10);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}
