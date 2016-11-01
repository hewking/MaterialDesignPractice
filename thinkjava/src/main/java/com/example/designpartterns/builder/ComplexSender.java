package com.example.designpartterns.builder;

import com.example.designpartterns.factorymethod.MailSender;
import com.example.designpartterns.factorymethod.SmsSender;

/**
 * Created by hewking on 2016/11/1.
 */

public class ComplexSender {
    private SmsSender smsSender;
    private MailSender mailSender;

    public void send(){
        smsSender.send();
        mailSender.send();
    }

    static class Builder{

        private SmsSender smsSender;
        private MailSender mailSender;

        public Builder setSmsSender(SmsSender sms){
            smsSender = sms;
            return this;
        }

        public Builder setMailSender(MailSender mail){
            mailSender = mail;
            return this;
        }

        public ComplexSender build(){
            ComplexSender complexSender = new ComplexSender();
            complexSender.mailSender = mailSender;
            complexSender.smsSender = smsSender;
            return complexSender;
        }
    }
}
