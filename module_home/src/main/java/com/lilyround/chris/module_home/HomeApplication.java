package com.lilyround.chris.module_home;

import com.lilyround.chris.lib_common.base.BaseApplication;


/*
 * Created by chris on 2018/7/6 15:25
 *
 */
public class HomeApplication extends BaseApplication {

    private static HomeApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static HomeApplication getHomeInstance() {
        return sInstance;
    }
}
