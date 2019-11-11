package com.oman.forward.pattern.create.abstractfactory;

import com.oman.forward.pattern.create.simplefactory.Animal;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:27
 * @email:zhoujiang2012@163.com
 */
public interface IAnimal {
    //抽象出来的接口，用来获取Animal
    Animal getAnimal();
}
