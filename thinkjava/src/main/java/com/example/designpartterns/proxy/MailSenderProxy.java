package com.example.designpartterns.proxy;

import com.example.designpartterns.factorymethod.MailSender;
import com.example.designpartterns.factorymethod.Sender;

/**
 * Created by hewking on 2016/11/2.
 */

public class MailSenderProxy implements Sender {

    Sender sender;

    MailSenderProxy(){
        sender = new MailSender();
    }

    @Override
    public void send() {
        System.out.println("mailsenderproxy");
        sender.send();
    }
}
