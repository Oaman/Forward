package com.oman.forward.pattern.create.singleton;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:39
 * @email:zhoujiang2012@163.com
 */
public class Person2 {
    /**
     * 这样虽然我们不先创建实例了，但是如果在多线程中显然我们的对象会被创建很多次，那么单例也就无效了，怎么办呢？对了，加锁
     */
    private static Person2 INSTANCE = null;

    private Person2() {}

    public static Person2 getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new Person2();
        }
        return INSTANCE;
    }
}