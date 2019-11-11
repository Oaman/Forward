package com.oman.forward.pattern.create.abstractfactory;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:33
 * @email:zhoujiang2012@163.com
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("抽象工厂方法模式:");
        new DogFactory().getAnimal().eat();
        new CatFactory().getAnimal().eat();
        new BirdFactory().getAnimal().eat();
        System.out.println("------------------");
    }
}