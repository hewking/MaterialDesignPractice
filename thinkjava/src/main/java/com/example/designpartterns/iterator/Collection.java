package com.example.designpartterns.iterator;


/**
 * Created by hewking on 2016/11/5.
 */

public interface Collection<T> {

    Iterator iterator();

    int getSize();

    T get(int index);

    void add(T t);

}
