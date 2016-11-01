package com.example.designpartterns.adapter;

/**
 * Created by hewking on 2016/11/1.
 */

public class SourceSub2 extends Wrapper2 {
    @Override
    public void method2() {
        super.method1();
        System.out.println("source sub2");
    }
}
