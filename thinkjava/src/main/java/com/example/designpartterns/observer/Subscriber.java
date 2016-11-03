package com.example.designpartterns.observer;

/**
 * Created by hewking on 2016/11/3.
 */

public class Subscriber implements INotify {
    @Override
    public String notice() {
        System.out.print("卧槽你看美铝啊" +
                "");
        return "卧槽 你看美女啊";
    }
}
