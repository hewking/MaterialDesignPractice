package com.example.designpartterns.mediator;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public class User1 extends AbstractUser {

    User1(Mediator mediator) {
        super(mediator);
    }

    @Override
    void work() {
        System.out.println("user1 work");
    }
}
