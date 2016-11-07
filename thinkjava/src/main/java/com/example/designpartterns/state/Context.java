package com.example.designpartterns.state;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public class Context {

    public State state;

    public Context(State state){
        this.state = state;
    }

    public void method(){
        if(state.getValue().equals("state1")){
            state.method1();
        }else{
            state.method2();
        }
    }

}
