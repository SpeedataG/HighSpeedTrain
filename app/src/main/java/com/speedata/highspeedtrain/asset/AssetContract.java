package com.speedata.highspeedtrain.asset;

import android.content.Context;

import com.speedata.highspeedtrain.mvp.BasePresenter;
import com.speedata.highspeedtrain.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class AssetContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
        
    }
}