package com.lilyround.chris.module_home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;


/*
 * Created by chris on 2018/7/3 15:33
 *
 */
public class HomeAdapter extends VirtualLayoutAdapter {

    public HomeAdapter(@NonNull VirtualLayoutManager layoutManager) {
        super(layoutManager);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
