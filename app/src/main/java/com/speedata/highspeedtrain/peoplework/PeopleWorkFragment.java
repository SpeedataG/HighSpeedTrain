package com.speedata.highspeedtrain.peoplework;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.speedata.highspeedtrain.BaseFragment;
import com.speedata.highspeedtrain.FragmentAdapter;
import com.speedata.highspeedtrain.R;
import com.speedata.highspeedtrain.work.Work2Fragment;
import com.speedata.highspeedtrain.work.Work3Fragment;
import com.speedata.highspeedtrain.work.Work4Fragment;
import com.speedata.highspeedtrain.work.Work5Fragment;
import com.speedata.highspeedtrain.work.WorkFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PeopleWorkFragment extends BaseFragment {

    private CoordinatorLayout mHomeContainer;
    private AppBarLayout mAppBar;
    private TabLayout mTlTabs;
    private ViewPager mVpFragment;

    private List<Fragment> fragments;
    private String[] tabs = {"基础数据", "静态检测", "全面检测", "集中修理", "其他功能"};

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_work;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        fragments = new ArrayList<>();
        mHomeContainer = view.findViewById(R.id.home_container);
        mAppBar = view.findViewById(R.id.app_bar);
        mTlTabs = view.findViewById(R.id.tl_tabs);
        mVpFragment = view.findViewById(R.id.vp_fragment);

        for (int i = 0; i < tabs.length; i++) {
            mTlTabs.addTab(mTlTabs.newTab().setText(tabs[i]));
            switch (i) {
                case 0:
                    fragments.add(WorkFragment.newInstance());
                    break;
                case 1:
                    fragments.add(Work2Fragment.newInstance());
                    break;
                case 2:
                    fragments.add(Work3Fragment.newInstance());
                    break;
                case 3:
                    fragments.add(Work4Fragment.newInstance());
                    break;
                case 4:
                    fragments.add(Work5Fragment.newInstance());
                    break;
                default:
                    fragments.add(WorkFragment.newInstance());
                    break;
            }
        }
        mVpFragment.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragments));
        mVpFragment.setCurrentItem(0);//要设置到viewpager.setAdapter后才起作用
        mTlTabs.setupWithViewPager(mVpFragment);
        mTlTabs.setVerticalScrollbarPosition(0);
        //tlTabs.setupWithViewPager方法内部会remove所有的tabs，这里重新设置一遍tabs的text，否则tabs的text不显示
        for (int i = 0; i < tabs.length; i++) {
            mTlTabs.getTabAt(i).setText(tabs[i]);
//            mTlTabs.addTab(mTlTabs.newTab().setCustomView(tab_icon(tabs[i],R.drawable.ic1)));
        }

//        mVpFragment.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlTabs));
//        mTlTabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpFragment));
    }


//    private View tab_icon(String name,int iconID){
//        View newtab =  LayoutInflater.from(getActivity()).inflate(R.layout.icon_view,null);
//        TextView tv = (TextView) newtab.findViewById(R.id.tabtext);
//        tv.setText(name);
//        ImageView im = (ImageView)newtab.findViewById(R.id.tabicon);
//        im.setImageResource(iconID);
//        return newtab;
//    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}
