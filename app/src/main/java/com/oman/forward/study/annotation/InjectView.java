package com.oman.forward.study.annotation;

import androidx.annotation.IdRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:ZhouJiang
 * @date:2020/5/17 00:18
 * @email:zhoujiang2012@163.com
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectView {
    @IdRes int value();
}
