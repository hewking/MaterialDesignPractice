package com.example.designpartterns.flyweight;

/**
 * Created by hewking on 2016/11/2.
 */

public class FlyWeightTest {
    public static void main(String[] args){
        RequestQueue queue = new RequestQueue();
        Execute execute =  queue.getCurrentExecutor();
        execute.execute();
        queue.release();

        execute = queue.getCurrentExecutor();
        execute.execute();
        queue.release();
    }
}
