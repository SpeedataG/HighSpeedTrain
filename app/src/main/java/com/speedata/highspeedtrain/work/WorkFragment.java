package com.speedata.highspeedtrain.work;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.speedata.highspeedtrain.BaseFragment;
import com.speedata.highspeedtrain.InfoBean;
import com.speedata.highspeedtrain.R;
import com.speedata.highspeedtrain.RVAdapter;

import java.util.ArrayList;
import java.util.List;

import xyz.reginer.baseadapter.CommonRvAdapter;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class WorkFragment extends BaseFragment {

    private RVAdapter mAdapter;
    private List<InfoBean> datas;
    private RecyclerView mRvContent;

    public static WorkFragment newInstance() {
        Bundle args = new Bundle();
        WorkFragment fragment = new WorkFragment();
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
        mAdapter.setOnItemClickListener(new CommonRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view, int position) {
                String title = datas.get(position).getTitle();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                ImageView imageView = new ImageView(getActivity());
                switch (title) {
                    case "基础数据":
                        imageView.setImageResource(R.drawable.msg);
                        break;
                    case "支柱装配图":
                        imageView.setImageResource(R.drawable.zhuangpeitu);
                        break;
                    case "现场实物照片":
                        imageView.setImageResource(R.drawable.jianxiu);
                        break;
                    case "零部件组成及厂家":
                        imageView.setImageResource(R.drawable.lingbujian);
                        break;
                    case "支撑定位参数":
                        imageView.setImageResource(R.drawable.canshu);
                        break;
                    default:
                        imageView.setImageResource(R.drawable.msg);
                        break;
                }

                builder.setView(imageView);
                builder.setPositiveButton("关闭", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private void createData() {
        InfoBean infoBean = new InfoBean();
        infoBean.setTitle("基础数据");
        datas.add(infoBean);

        InfoBean infoBean1 = new InfoBean();
        infoBean1.setTitle("吊弦数据");
        datas.add(infoBean1);

        InfoBean infoBean2 = new InfoBean();
        infoBean2.setTitle("环境管理及附属设备");
        datas.add(infoBean2);

        InfoBean infoBean3 = new InfoBean();
        infoBean3.setTitle("支柱装配图");
        datas.add(infoBean3);

        InfoBean infoBean4 = new InfoBean();
        infoBean4.setTitle("支撑定位参数");
        datas.add(infoBean4);

        InfoBean infoBean5 = new InfoBean();
        infoBean5.setTitle("零部件组成及厂家");
        datas.add(infoBean5);

        InfoBean infoBean6 = new InfoBean();
        infoBean6.setTitle("现场实物照片");
        datas.add(infoBean6);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}
