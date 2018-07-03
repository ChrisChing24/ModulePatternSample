package com.lilyround.chris.lib_common.base;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import com.lilyround.chris.lib_common.R;
import com.lilyround.chris.lib_common.utils.StatusBarUtil;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


/**
 * Created by chris on 2018/7/2 14:12
 * Activity基类
 */
public abstract class RxBaseActivity extends RxAppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局内容
        
        setContentView(getLayoutId());
        //初始化控件
        initViews(savedInstanceState);

        StatusBarUtil.setColor(this, getResources().getColor(R.color.white));
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //设置leakCanary监测内存泄漏
        BaseApplication.getRefWatcher().watch(this);
    }

    /**
     * 设置布局layout
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化views
     *
     * @param savedInstanceState
     */
    public abstract void initViews(Bundle savedInstanceState);

    /**
     * 初始化toolbar
     */
    public  void initToolBar(){

    };

    /**
     * 加载数据
     */
    public void loadData() {
    }

    /**
     * 显示进度条
     */
    public void showProgressBar() {
    }

    /**
     * 隐藏进度条
     */
    public void hideProgressBar() {
    }

    /**
     * 初始化recyclerView
     */
    public void initRecyclerView() {
    }

    /**
     * 初始化refreshLayout
     */
    public void initRefreshLayout() {
    }

    /**
     * 设置数据显示
     */
    public void processData() {
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T findId(int id) {
        return (T) findViewById(id);
    }

    //设置android app 的字体大小不受系统字体大小改变的影响
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

}
