package com.oman.forward.pattern.create.abstractfactory;

import com.oman.forward.pattern.create.simplefactory.Animal;
import com.oman.forward.pattern.create.simplefactory.Dog;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:31
 * @email:zhoujiang2012@163.com
 */
public class DogFactory implements IAnimal {
    @Override
    public Animal getAnimal() {
        return new Dog();
    }
}
