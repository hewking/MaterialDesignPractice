package com.example.designpartterns.iterator;

import com.example.leetcode.ReverseLinkedList;

/**
 * Created by hewking on 2016/11/5.
 */

public class MyCollection<T> implements Collection<T> {

    ReverseLinkedList linkedList = new ReverseLinkedList<T>();

    @Override
    public Iterator iterator() {
        return new MyIterator<T>(this);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public T get(int index) {
        return (T) linkedList.get(index);
    }

    @Override
    public void add(T o) {
        linkedList.push(o);
    }



}
