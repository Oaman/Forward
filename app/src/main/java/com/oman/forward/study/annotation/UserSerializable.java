package com.oman.forward.study.annotation;

import java.io.Serializable;

/**
 * @author:ZhouJiang
 * @date:2020/5/17 08:53
 * @email:zhoujiang2012@163.com
 */
public class UserSerializable implements Serializable {
    private static final long serialVersionUID = 84085028450L;
    private String name;

    public UserSerializable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserSerializable{" +
                "name='" + name + '\'' +
                '}';
    }
}
