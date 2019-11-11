package com.oman.forward.pattern.create.simplefactory;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:04
 * @email:zhoujiang2012@163.com
 */
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("dog eat meat");
    }
}
