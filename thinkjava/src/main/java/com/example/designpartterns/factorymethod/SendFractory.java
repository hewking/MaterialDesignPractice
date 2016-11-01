package com.example.designpartterns.factorymethod;

/**
 * Created by hewking on 2016/11/1.
 */

public class SendFractory {

    public Sender send(String type){
        //参数检查

        if(type.equals("sms")){
            return new SmsSender();
        }else if(type.equals("mail")){
            return new MailSender();
        }
        return null;
    }

    public SmsSender smsSender(){
        return new SmsSender();
    }

    public MailSender mailSender(){
        return new MailSender();
    }

    public static SmsSender sSmsSender(){
        return new SmsSender();
    }

}
