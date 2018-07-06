package com.lilyround.chris.lib_common.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lilyround.chris.lib_common.utils.Utils;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/*
 * Created by chris on 2018/7/3 11:12
 * BaseApplication
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 */

public class BaseApplication extends Application {

    public static BaseApplication appContext;

//    static {
//        //设置全局的Header构建器
//        SmartRefreshLayout.setDefaultRefreshHeaderCreater((context, layout) -> {
//            layout.setPrimaryColorsId(android.R.color.transparent, android.R.color.black);//全局设置主题颜色
//            return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
//        });
//        //设置全局的Footer构建器
//        SmartRefreshLayout.setDefaultRefreshFooterCreater((context, layout) -> {
//            //指定为经典Footer，默认是 BallPulseFooter
//            return new ClassicsFooter(context).setDrawableSize(20);
//        });
//    }

    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = this;
        // 用于监测内存泄漏，一旦有则显示在log里，debug时会多安装一个"Leaks"的app
        //在leakCanary SDK1.5以前，Android 6.0以上系统可能会报FATAL EXCEPTION: IntentService[HeapAnalyzerService]
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        mRefWatcher = LeakCanary.install(this);
        // Normal app init code...

        Utils.init(this);
        if (Utils.isAppDebug()) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        //初始化ARouter
        ARouter.init(this);
    }


    public static BaseApplication getInstance() {
        return appContext;
    }

    public static RefWatcher getRefWatcher() {
        return getInstance().mRefWatcher;//获取leakCanary监测对象
    }



}
