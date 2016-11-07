package com.example.designpartterns.memento;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public class Memento {

    String value;

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    Memento(String value){
        this.value = value;
    }

}
