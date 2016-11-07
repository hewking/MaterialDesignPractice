package com.example.designpartterns.mediator;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public abstract class AbstractUser {

    Mediator mediator;

    Mediator getMediator(){
        return mediator;
    }

    AbstractUser(Mediator mediator){
        this.mediator = mediator;
    }

    abstract void work();

}
