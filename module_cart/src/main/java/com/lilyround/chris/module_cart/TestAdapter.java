package com.lilyround.chris.module_cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/*
 * Created by chris on 2018/8/1 15:39
 *
 */
public class TestAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList;

    public TestAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_test_lv, parent, false);
            holder.mTextView = convertView.findViewById(R.id.tv_test);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mTextView.setText(mList.get(position));
        return convertView;
    }

    class ViewHolder {
        TextView mTextView;
    }
}
