package com.oman.forward.pattern.create.singleton;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:48
 * @email:zhoujiang2012@163.com
 */
public class Person6 {
    /**
     * 其实就比Person5多了一个 volatile 关键字，禁止了指令重排序
     */
    private volatile static Person6 INSTANCE = null;

    private Person6() {
    }

    public static Person6 getInstance() {
        if (INSTANCE == null) {
            synchronized (Person6.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Person6();
                }
            }
        }
        return INSTANCE;
    }
}
