package com.lilyround.chris.lib_common.network;


import io.reactivex.disposables.Disposable;

/*
 * Created by chris on 2018/7/5 13:37
 * 所有网络请求的回调
 */
public interface RequestImpl {
    void loadSuccess(Object object);

    void loadFailed();

    void addSubscription(Disposable disposable);
}
