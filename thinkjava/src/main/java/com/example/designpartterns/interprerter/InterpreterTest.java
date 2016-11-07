package com.example.designpartterns.interprerter;

/**
 * Created by Administrator on 2016/11/7.
 * <p>解释器模式通常用于oop 的编译器编写。所以适用面比较小，顾名思义，解释器，就是用于对表达式进行解释。
 * 联系方式：。。。
 */
public class InterpreterTest {
    public static void main(String[] args){
        Context ctx = new Context(5,3);
        Expression exp = new Plus();
        System.out.println(exp.interpret(ctx));
        exp = new Minus();
        System.out.println(exp.interpret(ctx));
    }
}
