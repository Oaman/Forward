package com.oman.forward.pattern.create.factory;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:06
 * @email:zhoujiang2012@163.com
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("普通工厂模式----------");
        AnimalFactory1 factory = new AnimalFactory1();
        Animal cat = factory.getAnimal("cat");
        cat.eat();
        Animal dog = factory.getAnimal("dog");
        dog.eat();
        System.out.println("--------------------");
        System.out.println("多个工厂方法模式--------------");
        AnimalFactory2 factory2 = new AnimalFactory2();
        factory2.getCat().eat();
        factory2.getDog().eat();
        System.out.println("--------------------");
        System.out.println("静态工厂方法模式-----------");
        AnimalFactory3.getCat().eat();
        AnimalFactory3.getDog().eat();
        System.out.println("--------------------");
    }
}