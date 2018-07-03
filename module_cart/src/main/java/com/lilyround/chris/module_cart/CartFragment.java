package com.lilyround.chris.module_cart;

import android.view.View;

import com.lilyround.chris.lib_common.base.RxLazyFragment;


/*
 * Created by chris on 2018/7/3 13:32
 * 购物车fragment
 */
public class CartFragment extends RxLazyFragment {
    @Override
    public int getLayout() {
        return R.layout.fragment_cart;
    }

    @Override
    public void initViews(View view) {

    }

    @Override
    public void loadData() {

    }

    public static CartFragment instance() {
        return new CartFragment();
    }
}
