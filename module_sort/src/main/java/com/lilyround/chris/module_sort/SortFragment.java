package com.lilyround.chris.module_sort;

import android.view.View;

import com.lilyround.chris.lib_common.base.RxLazyFragment;


/*
 * Created by chris on 2018/7/3 13:37
 * 分类fragment
 */
public class SortFragment extends RxLazyFragment {
    @Override
    public int getLayout() {
        return R.layout.fragment_sort;
    }

    @Override
    public void initViews(View view) {

    }

    @Override
    public void loadData() {

    }

    public static SortFragment instance() {
        return new SortFragment();
    }
}
