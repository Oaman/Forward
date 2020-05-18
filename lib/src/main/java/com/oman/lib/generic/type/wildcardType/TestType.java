package com.oman.lib.generic.type.wildcardType;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * WildcardType
 * 该接口表示通配符泛型, 比如? extends Number 和 ? super Integer 它有如下方法:
 *
 * Type[] getUpperBounds(): 获取范型变量的上界
 * Type[] getLowerBounds(): 获取范型变量的下界
 * 注意:
 *
 * 现阶段通配符只接受一个上边界或下边界, 返回数组是为了以后的扩展, 实际上现在返回的数组的大小是1
 */
public class TestType {
    private List<? extends Number> a;  // 上限
    private List<? super String> b;     //下限

    public static void main(String[] args) throws Exception {
        Field fieldA = TestType.class.getDeclaredField("a");
        Field fieldB = TestType.class.getDeclaredField("b");
        // 先拿到范型类型
        ParameterizedType pTypeA = (ParameterizedType) fieldA.getGenericType();
        System.out.println(pTypeA);
        ParameterizedType pTypeB = (ParameterizedType) fieldB.getGenericType();
        System.out.println(pTypeB);
        // 再从范型里拿到通配符类型
        WildcardType wTypeA = (WildcardType) pTypeA.getActualTypeArguments()[0];
        WildcardType wTypeB = (WildcardType) pTypeB.getActualTypeArguments()[0];
        // 方法测试
        System.out.println(wTypeA.getUpperBounds()[0]);   // class java.lang.Number
        System.out.println(wTypeB.getLowerBounds()[0]);   // class java.lang.String
        // 看看通配符类型到底是什么, 打印结果为: ? extends java.lang.Number
        System.out.println(wTypeA);
    }
}
