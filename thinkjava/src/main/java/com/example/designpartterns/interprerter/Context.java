package com.example.designpartterns.interprerter;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public class Context {
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    private int num1;
    private int num2;

    Context(int num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
}
