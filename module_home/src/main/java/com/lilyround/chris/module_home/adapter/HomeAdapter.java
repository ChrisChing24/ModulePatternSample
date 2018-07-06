package com.lilyround.chris.module_home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;


/*
 * Created by chris on 2018/7/3 15:33
 * 首页布局recyclerview适配器
 */
public class HomeAdapter extends VirtualLayoutAdapter<HomeAdapter.HomeViewHolder> {

    public HomeAdapter(@NonNull VirtualLayoutManager layoutManager) {
        super(layoutManager);
    }

    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(HomeAdapter.HomeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        public HomeViewHolder(View itemView) {
            super(itemView);
        }
    }
}
