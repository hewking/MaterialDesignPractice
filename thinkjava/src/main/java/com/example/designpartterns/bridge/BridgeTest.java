package com.example.designpartterns.bridge;

/**
 * Created by hewking on 2016/11/2.
 */

public class BridgeTest {

    public static void main(String[] args){
        DriverManager manager = new DefaultDriverManager();
        manager.setDriver(new MySqlDriver());
        manager.connect();
    }
}
