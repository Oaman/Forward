package com.oman.forward.pattern.create.singleton;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:38
 * @email:zhoujiang2012@163.com
 */
public class Person {
    /**
     * 饿汉单例模式 直接初始化
     * 饿汉模式比较简单，但是有一个问题就是不管我们使用还是没使用这个类的实例，都会创建一个实例INSTANCE,这样显示是不太好的
     */
    private static final Person INSTANCE = new Person();

    private Person() {}

    public static Person getInstance() {
        return INSTANCE;
    }
}