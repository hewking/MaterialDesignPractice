package com.example.questions;

/**
 * Created by Administrator on 2016/10/18.
 * <p>
 * 联系方式：。。。
 * 开启两个线程，交叉打印信息，涉及到线程之间通信，在android中可以使用 Handler 即android消息机制完成
 *
 * 本题为一个线程打印123456... 另一个 abcdef... 最终打印 1a2b3c...
 */
public class TwoThreadIPC {


    private static  Object LOCK  = new Object();
    private static  boolean isExecute = false;

    public static void main(String[] args){

        int[] numbers = new int[10];
        char[] letters = new char[26];
        for (int i = 0 ; i < 10 ; i ++){
            numbers[i] = i;
        }
        for(int i = 0, k = 'a' ; k < 'z' + 1 ; k ++){
            letters[i ++ ] = (char)k;
        }


        Runnable printNum = new Runnable() {
            @Override
            public void run() {

                    for (int i = 0 ; i < 10 ; i ++){
                        synchronized (LOCK) {
                            System.out.println(numbers[i]);
                            if(isExecute){
                                isExecute = false;
                                LOCK.notify();
                                try {
                                    LOCK.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            }
        };

        Runnable printLetters = new Runnable() {
            @Override
            public void run() {
                    for(int k = 0 ; k < 26 ; k ++){
                        synchronized (LOCK) {
                            System.out.println(letters[k]);
                            if(!isExecute){
                                isExecute = true;
                                LOCK.notify();
                                try {
                                    LOCK.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
        };
        Thread thread1 = new Thread(printNum);
        Thread thread2 = new Thread(printLetters);
        thread2.start();
        thread1.start();

    }


}
