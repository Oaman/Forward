package com.oman.lib.structure;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        HashMap<String, String> map = new HashMap<>(8193);
        Field threshold = map.getClass().getDeclaredField("threshold");
        threshold.setAccessible(true);
        Object o = threshold.get(map);
        System.out.println(o);
//        System.out.println(map.size());
        int a = tableSizeFor(10000);
        System.out.println(a);
        int[] arrs = {3, 1, 1, 2, 2, 3, 3, 4, 4};
        System.out.println(getSingle(arrs));
        System.out.println();
        System.out.println(get(4));
        System.out.println(get(3));
        System.out.println(get(4096));
    }

    /**
     * 任何数&自己都是自己，任何数^自己都是0;
     * 获取数组中的唯一一个奇数，其余的全部是偶数
     */
    public static int getSingle(int[] arrs) {
        int result = 0;
        for (int i : arrs) {
            result ^= i;
        }
        return result;
    }

    /**
     * 快速查找某个数是不是2的N次幂
     * 主要是看最高位是否为1
     *      2 10  11
     *            10
     *      4 100
     *      8 1000
     */
    public static boolean get(int number) {
        return (number & (number - 1)) == 0;
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(n);//9999
        n |= n >>> 1;//
        System.out.println(n);//14232
        n |= n >>> 2;//
        System.out.println(n);//16367
        n |= n >>> 4;//
        System.out.println(n);//16383
        n |= n >>> 8;//
        System.out.println(n);//16383
        n |= n >>> 16;//
        System.out.println(n);//16384
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
