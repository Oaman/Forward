package com.oman.forward.pattern.create.simplefactory;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:11
 * @email:zhoujiang2012@163.com
 */
public class AnimalFactory3 {
    /**
     * 静态工厂方法模式
     * 直接定义为静态接口获取实例，方便调用
     */
    public static Animal getCat() {
        return new Cat();
    }

    public static Animal getDog() {
        return new Dog();
    }
}