package com.example.designpartterns.decorator;

import com.example.designpartterns.factorymethod.MailSender;

/**
 * Created by hewking on 2016/11/2.
 */

public class TestDecorator {
    public static void main(String[] args){
        new MailDecorator(new MailSender()).send();
    }
}
