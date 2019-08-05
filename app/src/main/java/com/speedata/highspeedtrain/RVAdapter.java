package com.speedata.highspeedtrain;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

import xyz.reginer.baseadapter.BaseAdapterHelper;
import xyz.reginer.baseadapter.CommonRvAdapter;

/**
 * Created by 张明_ on 2018/5/4.
 * Email 741183142@qq.com
 */

public class RVAdapter extends CommonRvAdapter<InfoBean> {
    public RVAdapter(Context context, int layoutResId, List<InfoBean> data) {
        super(context, layoutResId, data);
    }

    @Override
    public void convert(BaseAdapterHelper helper, InfoBean item, int position) {
        String title = item.getTitle();
        helper.setText(R.id.tv_title, title);
        if (title.equals("现场实物照片")) {
            helper.setVisible(R.id.tv_status, false);
        }
        if (title.equals("基础数据")) {
            helper.setVisible(R.id.tv_status, false);
        }
        if (title.equals("吊弦数据")) {
            helper.setVisible(R.id.tv_status, false);
        }
        if (title.equals("环境管理及附属设备")) {
            helper.setVisible(R.id.tv_status, false);
        }
        if (title.equals("支柱装配图")) {
            helper.setVisible(R.id.tv_status, false);
        }
        if (title.equals("支撑定位参数")) {
            helper.setVisible(R.id.tv_status, false);
        }
        if (title.equals("零部件组成及厂家")) {
            helper.setVisible(R.id.tv_status, false);
        }
    }
}
