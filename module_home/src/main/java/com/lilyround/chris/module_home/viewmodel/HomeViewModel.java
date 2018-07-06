package com.lilyround.chris.module_home.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.lilyround.chris.lib_common.base.BaseDelegateAdapter;
import com.lilyround.chris.lib_common.network.RequestImpl;
import com.lilyround.chris.module_home.model.HomeModel;
import com.lilyround.chris.module_home.ui.HomeFragment;

import io.reactivex.disposables.Disposable;


/*
 * Created by chris on 2018/7/3 16:52
 * 主页ViewModel
 */
public class HomeViewModel extends ViewModel implements HomeNavigator.ViewModelImpl {


    private HomeFragment mHomeFragment;
    private final HomeModel mModel;
    private HomeNavigator.View mNavigator;

    public HomeViewModel(HomeFragment fragment) {
        this.mHomeFragment = fragment;
        mModel = new HomeModel();
    }

    public void setNavigator(HomeNavigator.View navigator) {
        this.mNavigator = navigator;
    }

    public void loadHomeData() {
        mModel.getHomeData(new RequestImpl() {
            @Override
            public void loadSuccess(Object object) {

            }

            @Override
            public void loadFailed() {

            }

            @Override
            public void addSubscription(Disposable disposable) {
                mHomeFragment.addSubscription(disposable);
            }
        });
    }

    public void onDestroy(){
        mNavigator = null;
    }


    @Override
    public BaseDelegateAdapter initBanner1() {
//        return new BaseDelegateAdapter(mHomeFragment.getActivity(),new LinearLayoutHelper(),);
        return null;
    }

    @Override
    public BaseDelegateAdapter initGridView1() {
        return null;
    }

    @Override
    public BaseDelegateAdapter initImageView() {
        return null;
    }

    @Override
    public BaseDelegateAdapter initMarqueeView() {
        return null;
    }

    @Override
    public BaseDelegateAdapter initHorizontalGridView1() {
        return null;
    }

    @Override
    public BaseDelegateAdapter initHorizontalGridView2() {
        return null;
    }

    @Override
    public BaseDelegateAdapter initBanner2() {
        return null;
    }

    @Override
    public BaseDelegateAdapter initListView() {
        return null;
    }

    @Override
    public BaseDelegateAdapter initTabLayout() {
        return null;
    }

    @Override
    public BaseDelegateAdapter initHorizontalGridView3() {
        return null;
    }

    @Override
    public BaseDelegateAdapter initGridView2() {
        return null;
    }
}
