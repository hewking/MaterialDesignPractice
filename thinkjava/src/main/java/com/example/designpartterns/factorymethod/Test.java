package com.example.designpartterns.factorymethod;

import com.example.designpartterns.abrstractfactory.SmsProvider;

/**
 * Created by hewking on 2016/11/1.
 */

public class Test {
    public static void main(String[] args){
//        new SendFractory().send("mail").send();
        SendFractory.sSmsSender().send();
        new SendFractory().mailSender().send();
        new SmsProvider().provide().send();
    }
}
