package com.oman.forward.study.annotation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author:ZhouJiang
 * @date:2020/5/17 00:23
 * @email:zhoujiang2012@163.com
 */
class InjectUtils {
    // inject view
    static void injectView(Activity activity) {
        Field[] fields = activity.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(InjectView.class)) {
                InjectView annotation = f.getAnnotation(InjectView.class);
                int viewId = annotation.value();
                f.setAccessible(true);
                View view = activity.findViewById(viewId);
                try {
                    f.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void injectParams(Activity activity) {
        Field[] fields = activity.getClass().getDeclaredFields();
        Bundle extras = activity.getIntent().getExtras();
        if (extras == null) return;

        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectParams.class)) {
                InjectParams annotation = field.getAnnotation(InjectParams.class);
                String key = TextUtils.isEmpty(annotation.value()) ? field.getName() : annotation.value();
                if (extras.containsKey(key)) {
                    Object o = extras.get(key);

                    Class<?> componentType = field.getType().getComponentType();
                    // todo Parcelable数组类型不能直接设置，其他的都可以.所以需要单独处理
                    if (field.getType().isArray() && Parcelable.class.isAssignableFrom(componentType)) {
                        Object[] objs = (Object[]) o;
                        Object[] objects = Arrays.copyOf(objs, objs.length, (Class<? extends Object[]>) field.getType());
                        o = objects;
                    }

                    field.setAccessible(true);//important
                    try {
                        field.set(activity, o);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
