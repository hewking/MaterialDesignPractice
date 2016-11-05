package com.example.designpartterns.chain;

/**
 * Created by hewking on 2016/11/5.
 */

public class MyHandler<T> extends AbstractHandler {

    T t;

    public MyHandler(T t){
        this.t = t;
    }

    @Override
    public void operator() {
        if(getHandler() != null){
            getHandler().operator();
        }
        System.out.println(t);
    }
}
