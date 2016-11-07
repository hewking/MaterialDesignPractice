package com.example.designpartterns.mediator;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public class User2 extends AbstractUser {
    User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    void work() {
        System.out.println("user2 work");
    }


}
