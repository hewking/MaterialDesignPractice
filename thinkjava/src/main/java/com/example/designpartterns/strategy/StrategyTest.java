package com.example.designpartterns.strategy;

/**
 * Created by hewking on 2016/11/3.
 * 策略模式决定权在用户，算法本身由系统实现增删及修改，各种封装。一般用于算法得决策中
 */

public class StrategyTest {
    public static void main(String[] args){
        ICalculator calculator = new Plus();
        System.out.print(calculator.calculate("3+2"));
    }
}
