package com.example.designpartterns.adapter;

/**
 * Created by hewking on 2016/11/1.
 * 对象得适配器模式
 */

public class Wrapper implements TargetAble{

    private Source source;

    public Wrapper(Source source){
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {

    }
}
