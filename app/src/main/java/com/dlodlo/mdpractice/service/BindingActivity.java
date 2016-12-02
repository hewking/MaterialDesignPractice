package com.dlodlo.mdpractice.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.dlodlo.mdpractice.R;

/**
 * Created by Administrator on 2016/11/15.
 * <p>
 * 联系方式：。。。
 */
public class BindingActivity extends Activity {

    private Button tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_ry_test);
        tv = (Button) findViewById(R.id.tv1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bound){
                    String date = mBiner.getService().getCurrentDate();
                    tv.setText(date);
                }else{
                }
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,LocalService.class);
        bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }

    private boolean bound;

    private LocalService.LocalBinder mBiner;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBiner = (LocalService.LocalBinder) service;
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bound = false;
        }
    };
}
