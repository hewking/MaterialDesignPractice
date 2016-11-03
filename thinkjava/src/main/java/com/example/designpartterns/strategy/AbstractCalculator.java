package com.example.designpartterns.strategy;

/**
 * Created by hewking on 2016/11/3.
 */

public abstract class AbstractCalculator {
    public int[] split(String exp,String opt){
        int[] params = new int[2];
        String[] result = exp.split(opt);
        params[0] = Integer.valueOf(result[0]);
        params[1] = Integer.valueOf(result[1]);
        return params;
    }
}
