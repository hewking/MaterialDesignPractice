package com.example.designpartterns.observer;

import com.example.designpartterns.observer.deppthink.AbstractSubject;
import com.example.designpartterns.observer.deppthink.MySubject;
import com.example.designpartterns.observer.deppthink.Observer1;
import com.example.designpartterns.observer.deppthink.Observer2;

/**
 * Created by hewking on 2016/11/3.
 */

public class ObserverTest {
    public static void main(String[] args){
        Observer observer = new Observer();
        observer.setListener(new Subscriber());
        observer.see();

        AbstractSubject subject = new MySubject();
        subject.add(new Observer1());
        subject.add(new Observer2());
        subject.operate();
    }
}
