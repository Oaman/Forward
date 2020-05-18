package com.oman.forward.study.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:ZhouJiang
 * @date:2020/5/18 01:28
 * @email:zhoujiang2012@163.com
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@EventType(listenerType = View.OnClickListener.class,listenerSetter = "setOnClickListener")
public @interface OnClick {
    int[] value();
}
