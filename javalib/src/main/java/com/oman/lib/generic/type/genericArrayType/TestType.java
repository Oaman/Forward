package com.oman.lib.generic.type.genericArrayType;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * GenericArrayType
 * 泛型数组,组成数组的元素中有范型则实现了该接口; 它的组成元素是ParameterizedType或TypeVariable类型,它只有一个方法:
 * <p>
 * Type getGenericComponentType(): 返回数组的组成对象
 *
 * @param <T>
 */
public class TestType<T> {

    /**
     * - TypeVariable
     * 泛型类型变量。可以泛型上下限等信息；
     * - ParameterizedType
     * 具体的泛型类型，可以获得元数据中泛型签名类型(泛型真实类型)
     * - GenericArrayType
     * 当需要描述的类型是泛型类的数组时，比如List[],Map[]，此接口会作为Type的实现。
     * - WildcardType
     * 通配符泛型，获得上下限信息；
     */
    List<String>[] lists;
    List<T>[] lists2;

    public static void main(String[] args) throws Exception {
        Field f = TestType.class.getDeclaredField("lists");
        System.out.println(f.getGenericType());//java.util.List<java.lang.String>[]
        GenericArrayType genericType = (GenericArrayType) f.getGenericType();
        System.out.println(genericType.getGenericComponentType());//java.util.List<java.lang.String>
        System.out.println(genericType.getTypeName());//java.util.List<java.lang.String>[]
        System.out.println("---------------");
        Field f2 = TestType.class.getDeclaredField("lists2");
        System.out.println(f2.getGenericType());//java.util.List<T>[]
        GenericArrayType genericType2 = (GenericArrayType) f2.getGenericType();
        System.out.println(genericType2.getGenericComponentType());//java.util.List<T>
        System.out.println(genericType2.getTypeName());//java.util.List<T>[]
        System.out.println("-----------------------");

        Type genericComponentType = ((GenericArrayType) f.getGenericType()).getGenericComponentType();
        ParameterizedType parameterizedType = (ParameterizedType) genericComponentType;
        System.out.println(parameterizedType.getRawType());//interface java.util.List
        for (Type type : parameterizedType.getActualTypeArguments()) {
            System.out.println(type.getTypeName());//java.lang.String
        }
    }
}

