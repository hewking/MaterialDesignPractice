package com.example.designpartterns.visitor;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public interface Subject {

    String getSubject();

    void accept(Visitor visitor);

}
