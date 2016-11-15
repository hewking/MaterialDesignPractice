package com.dlodlo.mdpractice.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dlodlo.mdpractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/31.
 * <p>
 * 联系方式：。。。
 */
public class DeviceVH extends RecyclerView.ViewHolder {


    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;

    public DeviceVH(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }
}
