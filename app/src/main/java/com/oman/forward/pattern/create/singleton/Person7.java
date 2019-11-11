package com.oman.forward.pattern.create.singleton;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:49
 * @email:zhoujiang2012@163.com
 */
public class Person7 {
    private Person7() {
    }

    private static class SingletonHolder {
        private static final Person7 INSTANCE = new Person7();
    }

    /**
     * 静态内部类的方式获取单例
     * JVM在类的初始化阶段会执行类的初始化，JVM会去获取一个锁，
     * 这个锁可以同步多个线程对同一个类的初始化，这种写法比双重锁定单例模式简单。
     */
    public static Person7 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
