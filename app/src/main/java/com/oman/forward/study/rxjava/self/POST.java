package com.oman.forward.study.rxjava.self;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:ZhouJiang
 * @date:2020/5/27 21:19
 * @email:zhoujiang2012@163.com
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface POST {
    String value();
}
