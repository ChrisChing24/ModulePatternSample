package com.lilyround.chris.module_mine;

import android.view.View;
import android.widget.Button;

import com.lilyround.chris.lib_common.base.RxLazyFragment;


/*
 * Created by chris on 2018/7/3 13:35
 * 我的fragment
 */
public class MineFragment extends RxLazyFragment implements View.OnClickListener {


    @Override
    public int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initViews(View view) {

    }

    @Override
    public void loadData() {

    }

    public static MineFragment instance() {
        return new MineFragment();
    }

    @Override
    public void onClick(View v) {

    }
}
