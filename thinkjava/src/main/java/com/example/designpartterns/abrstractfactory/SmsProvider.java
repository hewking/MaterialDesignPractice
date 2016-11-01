package com.example.designpartterns.abrstractfactory;

import com.example.designpartterns.factorymethod.Sender;
import com.example.designpartterns.factorymethod.SmsSender;

/**
 * Created by hewking on 2016/11/1.
 */

public class SmsProvider implements Provider {
    @Override
    public Sender provide() {
        return new SmsSender();
    }
}
