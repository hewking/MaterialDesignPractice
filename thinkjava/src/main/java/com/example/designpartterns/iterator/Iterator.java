package com.example.designpartterns.iterator;

/**
 * Created by hewking on 2016/11/5.
 */

public interface Iterator<T> {

    boolean hasNext();

    T next();

    T previeous();

    T first();

}
