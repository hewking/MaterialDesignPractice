package com.example.designpartterns.observer.deppthink;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hewking on 2016/11/4.
 */

public abstract class AbstractSubject {
    List<IObserver> observers = new ArrayList<>();

    public IObserver add(IObserver observer){
        observers.add(observer);
        return observer;
    }

    public IObserver remove(IObserver observer){
        observers.remove(observer);
        return observer;
    }

    public void notifyAllObserver(){
        Iterator it = observers.iterator();
        while (it.hasNext()){
            IObserver observer = (IObserver) it.next();
            observer.update();
        }
    }

    public abstract void operate();
}
