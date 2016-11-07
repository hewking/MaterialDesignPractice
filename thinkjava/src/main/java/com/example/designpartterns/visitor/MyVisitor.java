package com.example.designpartterns.visitor;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public class MyVisitor implements Visitor {
    @Override
    public void visit(Subject subject) {
        System.out.println(subject.getSubject());
    }
}
