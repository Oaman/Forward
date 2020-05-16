package com.oman.lib.jdk;

/**
 * @author:ZhouJiang
 * @date:2020/5/5 17:24
 * @email:zhoujiang2012@163.com
 */
public class GCRootLocalVariable {
    private int _10M = 10 * 1024 * 1024;
    private int[] MEMORY = new int[8 * _10M];

    public static void main(String[] args) {
        System.out.println("start");
        printMemory();
        method();
        System.gc();
        System.out.println("second gc finished");
        printMemory();
    }

    static void method() {
        GCRootLocalVariable g = new GCRootLocalVariable();
        System.gc();
        System.out.println("first gc finished");
        printMemory();
    }

    static void printMemory() {
        System.out.println("free is:" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println("total is:" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
    }
}
