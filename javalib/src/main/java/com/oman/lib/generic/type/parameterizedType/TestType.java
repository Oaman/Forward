package com.oman.lib.generic.type.parameterizedType;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;

/**
 * ParameterizedType
 * 具体的泛型类型, 如Map<String, String>
 * 有如下方法:
 * <p>
 * Type getRawType(): 返回承载该泛型信息的对象, 如上面那个Map<String, String>承载范型信息的对象是Map
 * Type[] getActualTypeArguments(): 返回实际泛型类型列表, 如上面那个Map<String, String>实际范型列表中有两个元素, 都是String
 */
public class TestType<T, E> {
    Map<String, String> map;
    Map<T, E> map2;
    List<List<? extends String>> list;

    public static void main(String[] args) throws Exception {
        Field f = TestType.class.getDeclaredField("map");
        System.out.println(f.getGenericType());                               // java.util.Map<java.lang.String, java.lang.String>
        ParameterizedType pType = (ParameterizedType) f.getGenericType();
        System.out.println(pType.getRawType());                               // interface java.util.Map
        for (Type type : pType.getActualTypeArguments()) {
            System.out.println(type);                                         // 打印两遍: class java.lang.String
        }
        System.out.println("--------------");
        Field f2 = TestType.class.getDeclaredField("map2");
        System.out.println(f2.getGenericType());                               // java.util.Map<java.lang.String, java.lang.String>
        ParameterizedType pType2 = (ParameterizedType) f2.getGenericType();
        System.out.println(pType2.getRawType());                               // interface java.util.Map
        for (Type type : pType2.getActualTypeArguments()) {
            System.out.println(type);                                         // 打印两遍: class java.lang.String
        }
        System.out.println("------------------------------");
        Field field = TestType.class.getDeclaredField("list");
        ParameterizedType parameterizedType = (ParameterizedType)field.getGenericType();
        System.out.println(parameterizedType.getTypeName());
        ParameterizedType parameterizedType1 = (ParameterizedType) parameterizedType.getActualTypeArguments()[0];
        System.out.println(parameterizedType1.getTypeName());
        WildcardType  type = (WildcardType) parameterizedType1.getActualTypeArguments()[0];
        System.out.println(type.getTypeName());
        System.out.println(type.getUpperBounds()[0]);
    }
}
