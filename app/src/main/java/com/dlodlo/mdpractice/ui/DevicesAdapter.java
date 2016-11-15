package com.dlodlo.mdpractice.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/10/31.
 * <p>
 * 联系方式：。。。
 */
public class DevicesAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DeviceVH(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DeviceVH deviceVH = (DeviceVH) holder;

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
