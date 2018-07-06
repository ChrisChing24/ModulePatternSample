package com.lilyround.chris.module_home.model;


import android.annotation.SuppressLint;

import com.lilyround.chris.lib_common.network.ApiBase;
import com.lilyround.chris.lib_common.network.RequestImpl;
import com.lilyround.chris.module_home.HomeApplication;
import com.lilyround.chris.module_home.api.HomeService;
import com.lilyround.chris.module_home.bean.HomeBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/*
 * Created by chris on 2018/7/5 11:04
 *
 */
public class HomeModel {

    @SuppressLint("CheckResult")
    public void getHomeData(RequestImpl listener) {
        Disposable disposable = ApiBase
                .createApi(HomeService.class, HomeApplication.getHomeInstance())
                .getHomeData("1", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeBean>() {
                    @Override
                    public void accept(HomeBean homeBean) throws Exception {
                        listener.loadSuccess(homeBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        listener.loadFailed();
                    }
                });

        listener.addSubscription(disposable);
    }
}
