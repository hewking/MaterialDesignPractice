package com.example.designpartterns.chain;

/**
 * Created by hewking on 2016/11/5.
 * chain of responsibility
 * 有多个对象，每个对象持有对下一个对象的引用，这样就会形成一条链，请求在这条链上传递，直到某一对象决定处理该请求。但是发出者并不清楚到底最终那个对象会处理该请求，
 * 所以，责任链模式可以实现，在隐瞒客户端的情况下，对系统进行动态的调整
 * */

public class ChainTEst {
    public static void main(String[] args){
        AbstractHandler handler1 = new MyHandler<String>("1");
        AbstractHandler handler2 = new MyHandler<String>("2");
        AbstractHandler handler3 = new MyHandler<String>("3");
        handler1.setHandler(handler2);
        handler2.setHandler(handler3);
        handler1.operator();
    }
}
