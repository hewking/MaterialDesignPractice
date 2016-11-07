package com.example.designpartterns.mediator;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public class MyMediator
        implements Mediator {

    User1 user1;

    User2 user2;

    @Override
    public void createMediator() {
        user1 = new User1(this);
        user2 = new User2(this);
    }

    @Override
    public void work1() {
        user1.work();
    }

    @Override
    public void work2() {
        user2.work();
    }
}
