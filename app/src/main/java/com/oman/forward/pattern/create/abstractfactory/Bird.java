package com.oman.forward.pattern.create.abstractfactory;

import com.oman.forward.pattern.create.simplefactory.Animal;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:31
 * @email:zhoujiang2012@163.com
 */
public class Bird implements Animal {
    @Override
    public void eat() {
        System.out.println("bird eat worm");
    }
}