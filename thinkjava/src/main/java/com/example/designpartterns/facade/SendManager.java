package com.example.designpartterns.facade;

import com.example.designpartterns.factorymethod.MailSender;
import com.example.designpartterns.factorymethod.Sender;
import com.example.designpartterns.factorymethod.SmsSender;

/**
 * Created by hewking on 2016/11/2.
 * 外观模式 用于不同得类 之间得关系得到配置再一个类中，减少依赖关系。降低耦合
 */

public class SendManager implements Sender {

    SmsSender smsSender;
    MailSender mailSender;

    SendManager(){
       smsSender = new SmsSender();
        mailSender = new MailSender();
    }

    @Override
    public void send() {
        smsSender.send();
        mailSender.send();
    }
}
