package com.oman.lib.structure;


public class TestMod {
    public static void main(String[] args) {
        System.out.println("-3,2取模" + Math.floorMod(-3, 2));//1
        System.out.println("-3,2取余" + -3 % 2);//-1
        System.out.println("3,-2取模" + Math.floorMod(3, -2));//-1  = 3 - -2&-2
        System.out.println("3,-2取余" + 3 % -2);//1

        System.out.println(7 % 4);
        System.out.println(-7 % 4);
        System.out.println(7 % -4);
        System.out.println(-7 % -4);
        System.out.println(9 % -4);
        System.out.println(-9 % 4);
        System.out.println("----------取余% 符号相同，正常取余; 符号相反,结果符号与第一个数相同------------");
        System.out.println("----------取模  符号相同，取模同余; 符号相反,结果与第一个数相反------------");
        System.out.println(Math.floorMod(7, 4));
        System.out.println(Math.floorMod(-7, 4));
        System.out.println(Math.floorMod(7, -4));
        System.out.println(Math.floorMod(-7, -4));
        System.out.println(Math.floorMod(-9, 4));
        System.out.println(Math.floorMod(9, -4));

        System.out.println(13 % 4);
        System.out.println(13 % -4);
        System.out.println(-13 % 4);
        System.out.println(-13 % -4);
        System.out.println(Math.floorMod(13, 4));
        System.out.println(Math.floorMod(13, -4));
        System.out.println(Math.floorMod(-13, 4));
        System.out.println(Math.floorMod(-13, -4));
    }
}
