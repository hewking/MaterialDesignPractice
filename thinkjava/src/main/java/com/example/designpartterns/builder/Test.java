package com.example.designpartterns.builder;

import com.example.designpartterns.factorymethod.MailSender;
import com.example.designpartterns.factorymethod.SmsSender;

/**
 * Created by hewking on 2016/11/1.
 */

public class Test {
    public static void main(String[] args){
        ComplexSender sender = new ComplexSender.Builder().setMailSender(new MailSender()).setSmsSender(new SmsSender()).build();
        sender.send();
    }
}
