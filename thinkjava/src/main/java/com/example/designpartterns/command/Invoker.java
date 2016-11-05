package com.example.designpartterns.command;

/**
 * Created by hewking on 2016/11/6.
 */

public class Invoker {

    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void action(){
        command.command();
    }
}
