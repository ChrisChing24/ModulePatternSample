package com.lilyround.chris.lib_common.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;


/**
 * Created by chris on 2018/7/2 14:12
 * Fragment基类
 */
public abstract class RxLazyFragment extends RxFragment {
    /**
     * 控件是否初始化完成
     */
    private boolean isViewCreated;
    /**
     * 数据是否已加载完毕
     */
    private boolean isLoadDataCompleted;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayout(), container, false);
        initViews(mView);
        isViewCreated = true;
        return mView;
    }

    public abstract int getLayout();

    public abstract void initViews(View view);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isViewCreated && !isLoadDataCompleted) {
            isLoadDataCompleted = true;
            loadData();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getUserVisibleHint()) {
            isLoadDataCompleted = true;
            loadData();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //设置leakCanary监测内存泄漏
        BaseApplication.getRefWatcher().watch(this);
    }

    /**
     * 子类实现加载数据的方法
     */
    public abstract void loadData();


    /**
     * 显示进度条
     */
    protected void showProgressBar() {
    }

    /**
     * 隐藏进度条
     */
    protected void hideProgressBar() {
    }

    /**
     * 初始化recyclerView
     */
    protected void initRecyclerView() {
    }

    /**
     * 初始化refreshLayout
     */
    protected void initRefreshLayout() {
    }

    /**
     * 设置数据显示
     */
    protected void processData() {
    }


    @SuppressWarnings("unchecked")
    public <T extends View> T findId(int id) {
        return (T) mView.findViewById(id);
    }
}
