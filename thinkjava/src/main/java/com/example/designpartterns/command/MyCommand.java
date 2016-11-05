package com.example.designpartterns.command;

/**
 * Created by hewking on 2016/11/6.
 */

public class MyCommand implements Command {

    Receiver receiver;

    public MyCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void command() {
        receiver.action();
    }
}
