package com.example.designpartterns.state;

/**
 * Created by Administrator on 2016/11/7.
 * <p>状态模式，是通过改变状态改变其行为，像qq一样有上线，离线等状态。改变状态从而又不同行为
 * 每个状态对应不同的操作，而且你的好友也能看到你的状态，所以，状态模式就两点：1、可以通过改变状态来获得不同的行为。2、你的好友能同时看到你的变化
 * 联系方式：。。。
 */
public class StateTest
{
    public static void main(String[] args){
        State state = new State("state1");
        Context context = new Context(state);
        context.method();

        state.setValue("value2");
        context.method();
    }
}
