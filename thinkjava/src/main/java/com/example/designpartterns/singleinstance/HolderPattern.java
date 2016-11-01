package com.example.designpartterns.singleinstance;

/**
 * Created by hewking on 2016/11/1.
 */

public class HolderPattern {

    private HolderPattern(){}

    private static class Holder{
       private static HolderPattern instance = new HolderPattern();
    }

    public static HolderPattern getInstance(){
        return Holder.instance;
    }

}
