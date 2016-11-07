package com.example.designpartterns.memento;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public class Storage {

    Memento memento;

    Storage(Memento memento){
        this.memento = memento;
    }

    public void setMemento(Memento memento){
        this.memento = memento;
    }

    public Memento getMemento(){
        return this.memento;
    }

}
