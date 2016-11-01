package com.example.designpartterns.singleinstance;

/**
 * Created by hewking on 2016/11/1.
 */

public class HungryPattern {

    private HungryPattern(){}

    private static HungryPattern sInstance= new HungryPattern();

    public static HungryPattern getInstance(){
        return sInstance;
    }

}
