package com.example.designpartterns.adapter;

/**
 * Created by hewking on 2016/11/1.
 */

public class Adapter extends Source implements TargetAble{
    @Override
    public void method2() {
        System.out.println("targetable method2");
    }
}
