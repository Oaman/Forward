package com.oman.forward.pattern.structure.flyweight;

import java.util.HashMap;

/**
 * @author:ZhouJiang
 * @date:2019/11/16 13:52
 * @email:zhoujiang2012@163.com
 */
public class PersonFactory {

    private static final HashMap<Integer, Person> MAP = new HashMap<>();

    public static Person getPerson(int id) {
        Person person = MAP.get(id);
        if (null == person) {
            person = new Person();
            person.setId(id);
            MAP.put(id, person);
            System.out.println("开始创建ID为" + id + "的实例--------------------");
        }
        return person;
    }
}
