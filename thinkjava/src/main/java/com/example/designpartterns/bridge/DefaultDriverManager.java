package com.example.designpartterns.bridge;

/**
 * Created by hewking on 2016/11/2.
 */

public class DefaultDriverManager extends DriverManager {
    @Override
    public void connect() {
        getDriver().connect();
    }
}
