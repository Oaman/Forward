package com.oman.forward.study.annotation;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author:ZhouJiang
 * @date:2020/5/17 18:27
 * @email:zhoujiang2012@163.com
 */
public class TestRetention {
    public static void main(String[] args) {
        get(TYPE_NAME);
        get(TYPE_AGE);
//        get(3);//IDEA提示错误
    }

    private static void get(@Type int type) {
        if (type == TYPE_NAME) {
            System.out.println("type=1");
        } else {
            System.out.println("type=2");
        }
    }


    static final int TYPE_NAME = 1;
    static final int TYPE_AGE = 2;

    @IntDef({TYPE_NAME, TYPE_AGE})
    @Retention(RetentionPolicy.SOURCE)
    @interface Type {
    }
}


