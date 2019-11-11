package com.oman.forward.pattern.create.simplefactory;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:09
 * @email:zhoujiang2012@163.com
 */
public class AnimalFactory2 {
    /**
     * 多个方法工厂模式
     * 直接定义为接口获取实例，避免字符串出错
     */
    public Animal getCat() {
        return new Cat();
    }

    public Animal getDog() {
        return new Dog();
    }
}