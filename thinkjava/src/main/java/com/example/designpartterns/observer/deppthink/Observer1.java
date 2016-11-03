package com.example.designpartterns.observer.deppthink;

/**
 * Created by hewking on 2016/11/4.
 */

public class Observer1 implements IObserver {
    @Override
    public void update() {
        System.out.println("observer1");
    }
}
