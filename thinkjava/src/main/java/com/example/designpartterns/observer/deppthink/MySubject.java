package com.example.designpartterns.observer.deppthink;

/**
 * Created by hewking on 2016/11/4.
 * 观察者模式最重要有以下特征：
 * 1，首先要有被观察者，观察者。按照常理是观察者 观察 被观察者 动作是观察。但是再程序中这样会破坏代码结构并不采用。而是采用
 * 被观察者添加一个观察者。
 * 2，被观察者需要有所改变通知所有观察者，即有 被订阅得时间到来时，要notify 所有观察者。
 * 总结：所谓观察者模式。最重要是被观察者作为主类，例如star github 仓库。 仓库被作为被观察者，一旦仓库有修改或是新的
 * issue. 意味着有被订阅得事件产生。所以会通知所以观察者，即调用观察者方法。
 */

public class MySubject extends AbstractSubject {
    @Override
    public void operate() {
        System.out.println("operate");
        notifyAllObserver();
    }
}
