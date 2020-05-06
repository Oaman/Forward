package com.oman.forward.study.jdk;

import java.io.Serializable;

/**
 * @author:ZhouJiang
 * @date:2020/5/5 18:15
 * @email:zhoujiang2012@163.com
 */
public class Test implements Serializable, Cloneable {
    private int num = 1;

    public int add(int i) {
        int j = 10;
        num = num + i;
        return num;
    }
}
