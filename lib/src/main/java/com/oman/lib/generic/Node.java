package com.oman.lib.generic;

/**
 * @author:ZhouJiang
 * @date:2020/5/16 22:32
 * @email:zhoujiang2012@163.com
 */
public class Node<T> {
    T t;

    public Node(T t) {
        this.t = t;
    }

    public void set(T t) {
        this.t = t;
    }
}


class MyNode extends Node<String> {

    public MyNode(String s) {
        super(s);
    }

    @Override
    public void set(String s) {
        super.set(s);
    }
}

