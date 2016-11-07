package com.example.designpartterns.visitor;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public class MySubject implements Subject {

    String value ;

    MySubject(String value){
        this.value = value;
    }

    @Override
    public String getSubject() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
