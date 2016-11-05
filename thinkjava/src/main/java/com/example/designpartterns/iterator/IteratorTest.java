package com.example.designpartterns.iterator;

/**
 * Created by hewking on 2016/11/5.
 */

public class IteratorTest
{
    public static void main(String[] args){
        Collection collection = new MyCollection<String>();
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        collection.add("ddd");
        Iterator it = collection.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
