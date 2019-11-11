package com.oman.forward.pattern.create.factory;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:05
 * @email:zhoujiang2012@163.com
 */
public class AnimalFactory1 {
    /**
     * 普通工厂方法模式
     * 这种设计模式有一个问题就是参数，每次我们创建一个对象都需要输入一个字符串，这样有输入错误的风险
     */
    public Animal getAnimal(String animalName) {
        if ("cat".equals(animalName)) {
            return new Cat();
        } else if ("dog".equals(animalName)) {
            return new Dog();
        } else {
            throw new IllegalArgumentException("don't have this animal");
        }
    }
}