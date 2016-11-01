package com.example.innerclass;

/**
 * Created by Administrator on 2016/10/26.
 * <p>
 * 联系方式：。。。
 */
public class A {

    private static class Holder{
        private static int a = 5;
    }

    public void test(){
        int b = Holder.a;
    }

}
