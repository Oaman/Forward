package com.oman.forward.pattern.create.singleton;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:52
 * @email:zhoujiang2012@163.com
 */
public class Test {
    public static void main(String[] args) {
        Person p1 = Person.getInstance();
        Person p11 = Person.getInstance();
        System.out.println(p1 == p11);
        System.out.println("-----------------");
        Person2 p2 = Person2.getInstance();
        Person2 p22 = Person2.getInstance();
        System.out.println(p2 == p22);
        System.out.println("-----------------");
        Person3 p3 = Person3.getInstance();
        Person3 p33 = Person3.getInstance();
        System.out.println(p3 == p33);
        System.out.println("-----------------");
        Person4 p4 = Person4.getInstance();
        Person4 p44 = Person4.getInstance();
        System.out.println(p4 == p44);
        System.out.println("-----------------");
        Person5 p5 = Person5.getInstance();
        Person5 p55 = Person5.getInstance();
        System.out.println(p5 == p55);
        System.out.println("-----------------");
        Person6 p6 = Person6.getInstance();
        Person6 p66 = Person6.getInstance();
        System.out.println(p6 == p66);
        System.out.println("-----------------");
        Person7 p7 = Person7.getInstance();
        Person7 p77 = Person7.getInstance();
        System.out.println(p7 == p77);
        System.out.println("-----------------");
    }
}
