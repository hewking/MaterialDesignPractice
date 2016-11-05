package com.example.designpartterns.iterator;

/**
 * Created by hewking on 2016/11/5.
 */

public class MyIterator<T> implements Iterator {

    Collection<T> collection;

    private int pos = -1;

    MyIterator(Collection<T> collection){
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        if( pos < collection.getSize()){
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        pos += 1;
        return collection.get(pos);
    }

    @Override
    public T previeous() {
        pos -= 1;
        return collection.get(pos);
    }

    @Override
    public T first() {
        pos = 0;
        return collection.get(pos);
    }
}
