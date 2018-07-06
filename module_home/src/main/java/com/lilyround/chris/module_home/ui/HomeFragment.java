package com.lilyround.chris.module_home.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.lilyround.chris.lib_common.base.RxLazyFragment;
import com.lilyround.chris.module_home.R;
import com.lilyround.chris.module_home.adapter.HomeAdapter;
import com.lilyround.chris.module_home.viewmodel.HomeNavigator;
import com.lilyround.chris.module_home.viewmodel.HomeViewModel;

import java.util.LinkedList;
import java.util.List;


/*
 * Created by chris on 2018/7/2 15:49
 * 主页fragment
 */
public class HomeFragment extends RxLazyFragment implements HomeNavigator.View {


    private HomeViewModel mViewModel;

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initViews(View view) {
        RecyclerView recyclerView = findId(R.id.rv_home);
        mViewModel = new HomeViewModel(this);
        mViewModel.setNavigator(this);

        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        //创建layoutHelper集合
        List<LayoutHelper> helperList = new LinkedList<>();
        //创建网格布局，每行5个
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setItemCount(10);//设置总条目10个
        gridLayoutHelper.setHGap(20);//设置横向间距
        gridLayoutHelper.setVGap(20);//设置纵向间距
        helperList.add(gridLayoutHelper);
        //创建瀑布流布局,每行3个
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(3);
        staggeredGridLayoutHelper.setItemCount(24);
        staggeredGridLayoutHelper.setHGap(20);
        staggeredGridLayoutHelper.setVGap(20);
        helperList.add(staggeredGridLayoutHelper);
        //创建网格布局，每行5个
        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(2);
        gridLayoutHelper2.setItemCount(15);//设置总条目10个
        gridLayoutHelper2.setHGap(10);//设置横向间距
        gridLayoutHelper2.setVGap(10);//设置纵向间距
        helperList.add(gridLayoutHelper2);
        HomeAdapter adapter = new HomeAdapter(layoutManager);
        adapter.setLayoutHelpers(helperList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void loadData() {
        mViewModel.loadHomeData();
    }

    public static HomeFragment instance() {
        return new HomeFragment();
    }

    @Override
    public void showBanner1() {

    }

    @Override
    public void showGridView1() {

    }

    @Override
    public void showImageView() {

    }

    @Override
    public void showMarqueeView() {

    }

    @Override
    public void showHorizontalGridView1() {

    }

    @Override
    public void showHorizontalGridView2() {

    }

    @Override
    public void showBanner2() {

    }

    @Override
    public void showListView() {

    }

    @Override
    public void showTabLayout() {

    }

    @Override
    public void showHorizontalGridView3() {

    }

    @Override
    public void showGridView2() {

    }
}
