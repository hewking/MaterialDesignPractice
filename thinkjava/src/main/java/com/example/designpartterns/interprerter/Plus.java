package com.example.designpartterns.interprerter;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public class Plus implements Expression {
    @Override
    public int interpret(Context context) {
        return Math.min(context.getNum1(),context.getNum2());
    }
}
