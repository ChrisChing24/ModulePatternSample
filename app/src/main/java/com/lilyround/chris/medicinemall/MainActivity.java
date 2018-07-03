package com.lilyround.chris.medicinemall;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lilyround.chris.lib_common.base.RxBaseActivity;
import com.lilyround.chris.module_cart.CartFragment;
import com.lilyround.chris.module_home.HomeFragment;
import com.lilyround.chris.module_mine.MineFragment;
import com.lilyround.chris.module_sort.SortFragment;

/*
 * Created by chris on 2018/7/2 14:12
 * 主页
 */
public class MainActivity extends RxBaseActivity implements View.OnClickListener {


    private int tabIndex = 0;//底部按钮当前选中的index
    private int fragmentIndex = 0;//fragment显示的index
    private View[] mTabs;//底部按钮
    private Fragment[] mFragmentArray;//要展示的fragment

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        LinearLayout llHome = findId(R.id.ll_home);
        LinearLayout llSort = findId(R.id.ll_sort);
        ImageView ivPromotion = findId(R.id.iv_promotion);
        RelativeLayout rlCart = findId(R.id.rl_cart);
        RelativeLayout rlMine = findId(R.id.rl_mine);
        llHome.setOnClickListener(this);
        llSort.setOnClickListener(this);
        ivPromotion.setOnClickListener(this);
        rlCart.setOnClickListener(this);
        rlMine.setOnClickListener(this);
        //生成fragment实例
        HomeFragment homeFragment = HomeFragment.instance();
        SortFragment sortFragment = SortFragment.instance();
        CartFragment cartFragment = CartFragment.instance();
        MineFragment mineFragment = MineFragment.instance();
        //添加点击的view,促销活动跳转另外的页面，不是fragment，所以此处不需要添加
        mTabs = new View[]{llHome, llSort, rlCart, rlMine};
        //添加fragment
        mFragmentArray = new Fragment[]{homeFragment, sortFragment, cartFragment, mineFragment};
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_container, homeFragment)
                .commit();
        mTabs[fragmentIndex].setSelected(false);
        mTabs[tabIndex].setSelected(true);
        fragmentIndex = tabIndex;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home://首页
                tabIndex = 0;
                break;
            case R.id.ll_sort://分类
                tabIndex = 1;
                break;
            case R.id.iv_promotion://促销活动
                break;
            case R.id.rl_cart://购物车
                tabIndex = 2;
                break;
            case R.id.rl_mine://我的
                tabIndex = 3;
                break;
        }

        if (fragmentIndex != tabIndex) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(mFragmentArray[fragmentIndex]);
            if (!mFragmentArray[tabIndex].isAdded()) {
                transaction.add(R.id.fl_container, mFragmentArray[tabIndex]);
            }
            transaction.show(mFragmentArray[tabIndex]).commit();
        }
        mTabs[fragmentIndex].setSelected(false);
        mTabs[tabIndex].setSelected(true);
        fragmentIndex = tabIndex;
    }
}
