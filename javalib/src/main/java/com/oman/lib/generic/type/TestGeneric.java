package com.oman.lib.generic.type;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * @author:ZhouJiang
 * @date:2020/5/18 19:42
 * @email:zhoujiang2012@163.com
 */
public class TestGeneric {
    List<String> list;
    List<? extends Number> list2;
    List<String>[] list3;

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = TestGeneric.class.getDeclaredField("list");
        System.out.println(field.getGenericType());
        System.out.println(((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
        System.out.println(((ParameterizedType) field.getGenericType()).getRawType());
        System.out.println("----------------");
        Field field2 = TestGeneric.class.getDeclaredField("list2");
        WildcardType wildcardType = (WildcardType) ((ParameterizedType) field2.getGenericType()).getActualTypeArguments()[0];
        System.out.println(wildcardType.getUpperBounds()[0]);
//        System.out.println(wildcardType.getUpperBounds()[0]);//java.lang.ArrayIndexOutOfBoundsException: 0
        System.out.println("--------------------");
        Field field3 = TestGeneric.class.getDeclaredField("list3");
        GenericArrayType genericArrayType = (GenericArrayType) field3.getGenericType();
        Type genericComponentType = genericArrayType.getGenericComponentType();//java.util.List<java.lang.String>
        System.out.println(genericComponentType);
        ParameterizedType parameterizedType = (ParameterizedType) genericComponentType;
        System.out.println(parameterizedType.getActualTypeArguments()[0]);//class java.lang.String
    }
}
