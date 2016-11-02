package com.example.designpartterns.bridge;

/**
 * Created by hewking on 2016/11/2.
 */

public abstract class DriverManager implements Driver{

    Driver driver;

    void setDriver(Driver driver){
        this.driver = driver;
    }

    Driver getDriver(){
        return driver;
    }

    @Override
    public void connect() {
        driver.connect();
    }

    @Override
    public void disconnect() {
        driver.disconnect();
    }
}
