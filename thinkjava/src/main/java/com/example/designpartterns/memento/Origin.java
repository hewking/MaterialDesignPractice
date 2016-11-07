package com.example.designpartterns.memento;

/**
 * Created by Administrator on 2016/11/7.
 * <p>
 * 联系方式：。。。
 */
public class Origin {

    String value;

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    Origin(String value){
        this.value = value;
    }

    public Memento createMemento(){
        return new Memento(this.value);
    }

    public void restore(Memento memento){
        this.value = memento.getValue();
    }
}
