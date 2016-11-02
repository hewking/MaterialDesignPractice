package com.example.designpartterns.decorator;

import com.example.designpartterns.factorymethod.Sender;

/**
 * Created by hewking on 2016/11/2.
 */

public class MailDecorator implements Sender {

    Sender mailSender;

    MailDecorator(Sender sender){
        this.mailSender = sender;
    }

    @Override
    public void send() {
        System.out.println("MailDecorator send");
        mailSender.send();
    }
}
