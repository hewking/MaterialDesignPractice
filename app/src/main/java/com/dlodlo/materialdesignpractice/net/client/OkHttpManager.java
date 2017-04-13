package com.dlodlo.materialdesignpractice.net.client;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2016/10/25.
 * <p>
 * 联系方式：。。。
 */
public class OkHttpManager {

    private  OkHttpClient mOkHttpClient;


    private OkHttpManager(){
        mOkHttpClient = new OkHttpClient();
    }

    private static class Holder{
        private static OkHttpManager okHttpManager = new OkHttpManager();
    }

    public static OkHttpManager getInstance(){
        return Holder.okHttpManager;
    }

    public void getString(String url , Callback callback){
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }

}
