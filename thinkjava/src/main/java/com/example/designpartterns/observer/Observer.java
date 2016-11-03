package com.example.designpartterns.observer;

/**
 * Created by hewking on 2016/11/3.
 */

public class Observer {

    private INotify listener;

    public void setListener(INotify listener){
        this.listener = listener;
    }

    public void see(){
        listener.notice();
    }

}
