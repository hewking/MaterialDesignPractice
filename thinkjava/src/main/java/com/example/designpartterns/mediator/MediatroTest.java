package com.example.designpartterns.mediator;

/**
 * Created by Administrator on 2016/11/7.
 * <p>中介者模式属于中间类的模式，用于两个类相互依赖的情况，解耦。通过持有中介者，同时中介者持有用户类。用户类
 * 只需要关注与中介者之间的关系即可
 * 联系方式：。。。
 */
public class MediatroTest {

    public static void main(String[] args){

        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.work1();
        mediator.work2();

    }

}
