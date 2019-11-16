package com.oman.forward.pattern.structure.flyweight;

/**
 * @author:ZhouJiang
 * @date:2019/11/16 13:49
 * @email:zhoujiang2012@163.com
 */
public class Person {
    private int Id;
    private String name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
