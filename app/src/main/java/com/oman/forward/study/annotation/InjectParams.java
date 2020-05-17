package com.oman.forward.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:ZhouJiang
 * @date:2020/5/17 09:00
 * @email:zhoujiang2012@163.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectParams {
    String value() default "";
}
