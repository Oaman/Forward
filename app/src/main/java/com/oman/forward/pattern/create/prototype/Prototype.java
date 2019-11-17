package com.oman.forward.pattern.create.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 原型模型(prototype):
 * 要实现深复制，需要采用流的形式读入当前对象的二进制输入，再写出二进制数据对应的对象。
 */
public class Prototype implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    private String mString;
    private SerializableObject mSerializableObject;

    /**
     * 浅复制
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

    /**
     * 深复制
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        /**
         * 写入对象的二进制流
         */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /**
         * 读取二进制流产生的对象
         */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString() {
        return mString;
    }

    public void setString(String string) {
        mString = string;
    }

    public SerializableObject getSerializableObject() {
        return mSerializableObject;
    }

    public void setSerializableObject(SerializableObject serializableObject) {
        mSerializableObject = serializableObject;
    }

    public class SerializableObject implements Serializable {
        private static final long serialVersionUID = 1L;
    }

}
