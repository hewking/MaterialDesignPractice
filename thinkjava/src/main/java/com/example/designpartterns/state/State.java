package com.example.designpartterns.state;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public class State {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    String value;

    public State(String value){
        this.value = value;
    }

    public void method1(){
        System.out.println("execute method1");

    }

    public void method2(){
        System.out.println("excuete method2");
    }

}
