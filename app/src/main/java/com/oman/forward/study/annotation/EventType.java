package com.oman.forward.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:ZhouJiang
 * @date:2020/5/18 01:29
 * @email:zhoujiang2012@163.com
 */

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventType {
    Class<?> listenerType();

    String listenerSetter();
}
