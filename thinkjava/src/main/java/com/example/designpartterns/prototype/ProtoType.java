package com.example.designpartterns.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by hewking on 2016/11/1.
 */

public class ProtoType implements Cloneable,Serializable{

    private String result;

    //浅拷贝
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    //深拷贝
    public Object deepClone() throws IOException, ClassNotFoundException {
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();
    }

}
