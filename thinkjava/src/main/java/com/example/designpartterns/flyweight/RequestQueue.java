package com.example.designpartterns.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hewking on 2016/11/2.
 * 享元模式用于 实例对象得共享 即共享池 对象得复用 能够减少实例数量 从而减少内存开销
 */

public class RequestQueue {

    private List<Execute> execute;

    private Execute currentExecutor;

    private final int MAX_POOL_SIZE = 4;

    RequestQueue(){
        execute = new ArrayList<>();
        for(int i = 0 ; i < MAX_POOL_SIZE; i ++){
            execute.add(new DefaultExecutor(i + ">>>"));
        }
    }

    Execute getCurrentExecutor(){
        currentExecutor = execute.remove(0);
        return currentExecutor;
    }

    void release(){
        execute.add(currentExecutor);
        currentExecutor = null;
    }

}
