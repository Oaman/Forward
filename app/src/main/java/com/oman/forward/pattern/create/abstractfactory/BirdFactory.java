package com.oman.forward.pattern.create.abstractfactory;

import com.oman.forward.pattern.create.simplefactory.Animal;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:31
 * @email:zhoujiang2012@163.com
 */
public class BirdFactory implements IAnimal {
    /**
     * 这里你想获取一个Bird的话，创建一个BirdFactory
     * 没有违反OCP原则，以后想添加一个对象，直接创建一个就可以了，扩展性也很好
     */
    @Override
    public Animal getAnimal() {
        return new Bird();
    }
}
