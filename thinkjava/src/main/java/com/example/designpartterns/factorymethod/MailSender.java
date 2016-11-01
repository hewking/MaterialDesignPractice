package com.example.designpartterns.factorymethod;

/**
 * Created by hewking on 2016/11/1.
 */

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("mail sendlder");
    }
}
