package com.dlodlo.mdpractice.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Date;

/**
 * Created by Administrator on 2016/11/15.
 * <p>
 * 联系方式：。。。
 */
public class LocalService extends Service {

    private LocalBinder mBiner;


    public  class LocalBinder extends Binder {

        public LocalService getService(){
            return LocalService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBiner;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public String getCurrentDate(){
        return new Date().toString() + "getcurrentdate";
    }
}
