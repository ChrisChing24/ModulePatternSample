package com.lilyround.chris.module_home;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.lilyround.chris.lib_common.base.RxLazyFragment;
import com.lilyround.chris.module_home.adapter.HomeAdapter;


/*
 * Created by chris on 2018/7/2 15:49
 * 主页fragment
 */
public class HomeFragment extends RxLazyFragment {
    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initViews(View view) {
        RecyclerView recyclerView = findId(R.id.rv_home);
        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        HomeAdapter adapter = new HomeAdapter(layoutManager);

    }

    @Override
    public void loadData() {

    }

    public static HomeFragment instance() {
        return new HomeFragment();
    }
}
