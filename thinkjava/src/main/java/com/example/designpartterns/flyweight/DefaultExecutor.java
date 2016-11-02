package com.example.designpartterns.flyweight;

/**
 * Created by hewking on 2016/11/2.
 */

public class DefaultExecutor implements Execute {
    String type;

    DefaultExecutor(String type){
        this.type = type;
    }

    @Override
    public void execute() {
        System.out.println("defaultExecutor " + type);
    }
}
