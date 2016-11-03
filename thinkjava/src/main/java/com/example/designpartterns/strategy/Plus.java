package com.example.designpartterns.strategy;

/**
 * Created by hewking on 2016/11/3.
 */

public class Plus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] arr = split(exp,"\\+");
        return arr[0] + arr[1];
    }
}
