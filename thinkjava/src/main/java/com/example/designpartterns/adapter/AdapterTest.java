package com.example.designpartterns.adapter;

/**
 * Created by hewking on 2016/11/1.
 */

public class AdapterTest {
    public static void main(String[] args){
//        Adapter test = new Adapter();
//        test.method2();
//        test.method1();

        SourceSub1 sub1 = new SourceSub1();
        sub1.method1();
        sub1.method2();
        SourceSub2 sub2 = new SourceSub2();
        sub2.method1();
        sub2.method2();
    }
}
