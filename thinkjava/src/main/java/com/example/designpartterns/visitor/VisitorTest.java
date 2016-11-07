package com.example.designpartterns.visitor;

/**
 * Created by Administrator on 2016/11/7.
 * <p>访问者模式，适用于数据结构固定，行为与结构解耦，能够动态的配置行为。访问者通过传入被访问者从而调用其行为
 *
 * 联系方式：。。。
 */
public class VisitorTest {
    public static void main(String[] args){
        Subject subject = new MySubject("aaaaa");
        subject.accept(new MyVisitor());
    }
}
