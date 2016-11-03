package com.example.designpartterns.templatemethod;

/**
 * Created by hewking on 2016/11/3.
 */

public abstract class AbrstractCalculatro {

    public final int calculate(String exp,String opt){
        int[] result = split(exp,opt);
        return calculate(result[0],result[1]);
    }

    public abstract int calculate(int a,int b);

    private int[] split(String exp,String opt){
        String[] strings = exp.split(opt);
        return new int[]{Integer.valueOf(strings[0]),Integer.valueOf(strings[1])};
    }

}
