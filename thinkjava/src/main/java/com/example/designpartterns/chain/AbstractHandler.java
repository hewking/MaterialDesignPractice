package com.example.designpartterns.chain;

/**
 * Created by hewking on 2016/11/5.
 *
 */

public abstract class AbstractHandler  implements Handler{
    private Handler mHandler;

    public void setHandler(Handler handler){
        mHandler = handler;
    }

    public Handler getHandler(){
        return mHandler;
    }
}
