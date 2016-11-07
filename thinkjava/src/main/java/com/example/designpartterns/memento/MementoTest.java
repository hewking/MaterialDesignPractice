package com.example.designpartterns.memento;

/**
 * Created by Administrator on 2016/11/7.
 * <p>备忘录模式主要目地是用来在特定情况下保存类的状态，并在适当的时候恢复。比如类A 需要保存一下状态，能够创建备忘录，能够恢复备忘录。类B 作为备忘录保存 类A
 * 状态，类C 作为存储，存储备忘录B ,只能够读写，不能够更新。
 * 联系方式：。。。
 */
public class MementoTest {

    public static void main(String[] args){
        Origin origin = new Origin("value1");
        Memento memento = origin.createMemento();
        Storage storage = new Storage(memento);
        System.out.println(origin.getValue());
        origin.setValue("value2");
        System.out.println(origin.getValue());
        origin.restore(storage.getMemento());
        System.out.println(origin.getValue());
    }
}
