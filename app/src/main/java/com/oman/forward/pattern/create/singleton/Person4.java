package com.oman.forward.pattern.create.singleton;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:42
 * @email:zhoujiang2012@163.com
 */
public class Person4 {
    /**
     * 安全的饿汉模式（同步代码块）
     */
    private static Person4 INSTANCE = null;

    private Person4() {
    }

    public static Person4 getInstance() {
        synchronized (Person4.class) {
            if (null == INSTANCE) {
                INSTANCE = new Person4();
            }
        }
        return INSTANCE;
    }
}
