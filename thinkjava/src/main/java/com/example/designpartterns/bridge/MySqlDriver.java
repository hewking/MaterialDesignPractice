package com.example.designpartterns.bridge;

/**
 * Created by hewking on 2016/11/2.
 */

public class MySqlDriver implements Driver {
    @Override
    public void connect() {
        System.out.print("MysqlDriver connect");
    }

    @Override
    public void disconnect() {

    }
}
