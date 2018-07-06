package com.lilyround.chris.module_home.viewmodel;


import com.lilyround.chris.lib_common.base.BaseDelegateAdapter;

/*
 * Created by chris on 2018/7/5 10:31
 *
 */
public interface HomeNavigator {
    interface View {
        void showBanner1();

        void showGridView1();

        void showImageView();

        void showMarqueeView();

        void showHorizontalGridView1();

        void showHorizontalGridView2();

        void showBanner2();

        void showListView();

        void showTabLayout();

        void showHorizontalGridView3();

        void showGridView2();
    }

    interface ViewModelImpl {
        BaseDelegateAdapter initBanner1();

        BaseDelegateAdapter initGridView1();

        BaseDelegateAdapter initImageView();

        BaseDelegateAdapter initMarqueeView();

        BaseDelegateAdapter initHorizontalGridView1();

        BaseDelegateAdapter initHorizontalGridView2();

        BaseDelegateAdapter initBanner2();

        BaseDelegateAdapter initListView();

        BaseDelegateAdapter initTabLayout();

        BaseDelegateAdapter initHorizontalGridView3();

        BaseDelegateAdapter initGridView2();
    }



}
