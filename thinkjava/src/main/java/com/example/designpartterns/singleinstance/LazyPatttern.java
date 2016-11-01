package com.example.designpartterns.singleinstance;

/**
 * Created by hewking on 2016/11/1.
 */

public class LazyPatttern {
    private LazyPatttern(){}

    private static volatile LazyPatttern sInstance;

    public static LazyPatttern getInstance(){
        if(sInstance == null){
            synchronized (LazyPatttern.class){
                if(sInstance == null){
                    sInstance = new LazyPatttern();
                }
            }
        }
        return sInstance;
    }
}
