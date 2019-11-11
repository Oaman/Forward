package com.oman.forward.pattern.create.abstractfactory;

import com.oman.forward.pattern.create.simplefactory.Animal;
import com.oman.forward.pattern.create.simplefactory.Cat;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:30
 * @email:zhoujiang2012@163.com
 */
public class CatFactory implements IAnimal {

    @Override
    public Animal getAnimal() {
        return new Cat();
    }
}
