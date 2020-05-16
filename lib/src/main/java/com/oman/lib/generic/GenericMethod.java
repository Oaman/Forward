package com.oman.lib.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:ZhouJiang
 * @date:2020/5/16 20:56
 * @email:zhoujiang2012@163.com
 */
public class GenericMethod {
    public static void main(String[] args) {
//        List<String>[] stringLists = new ArrayList<String>[1];

        Serializable serializable = get("1", new ArrayList<>());

        List<Number> list = new ArrayList<>();
        list.add(1);
        list.add(2.0);
        print(list);
    }

    //通配符
    private static void print(List<? extends Number> list){
        System.out.println(list);
    }

    //通配符
    private static void print1(List<?> list){
//        list.add("");
        list.get(0);
        System.out.println(list);
    }

    //类型推断
    private static <T> T get(T t, T t2) {
        return t2;
    }

    private static <T> void test(T[] arr) {
        for (T t : arr) {
            System.out.println(t);
        }
    }
    static class Box<T>{}
}
