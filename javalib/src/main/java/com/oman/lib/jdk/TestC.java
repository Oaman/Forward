package com.oman.lib.jdk;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.join;

/**
 * @author:ZhouJiang
 * @date:2020/5/5 09:31
 * @email:zhoujiang2012@163.com
 */
public class TestC {
    public static void main(String[] args) {
//        String s = "abcdefg";
//        System.out.println(s.indexOf(2));
//        System.out.println(s.indexOf("c"));
//        System.out.println("".split(",").length);
//        System.out.println("".split(",")[0].equals(""));
//        List<String> integers = Arrays.asList("1", "2", "3");
//        System.out.println(String.join(",", integers));
//        String s1 = "java";
//        String s2 = s1;
//        System.out.println(s1 == s2);
//        s2 = "jav";
//        System.out.println(s1.equals(s2));

        String s1 = "HelloWorld";
        String s2 = new String("HelloWorld");
        String s3 = "Hello";
        String s4 = "World";
        String s5 = "Hello" + "World";
        String s6 = s3 + s4;

//        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s5 == s6);
//        System.out.println(s1 == s6);
        System.out.println(s1 == s2.intern());
        System.out.println(s2 == s2.intern());
    }
}

