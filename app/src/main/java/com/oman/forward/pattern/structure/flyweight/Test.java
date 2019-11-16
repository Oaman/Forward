package com.oman.forward.pattern.structure.flyweight;

/**
 * @author:ZhouJiang
 * @date:2019/11/16 13:55
 * @email:zhoujiang2012@163.com
 */
public class Test {

    private static int[] ids = {1001, 1002, 1003, 1004, 1005};
    private static String[] names = {"张三", "李四", "王五", "jack", "lucy"};

    /**
     * 享元模式：String的字符串缓冲池和数据库的连接池都是用此模式
     * 主要用于减少对象的创建数量，从而减少内存占用和提升性能
     * 1 首先创建一个对象
     * 2 需要一个唯一标识
     * 3 根据HashMap的key值决定缓冲池中是否有需要的对象，有的话就直接获取，没的话创建对象
     * 4 需要一个工厂模式来创建对象
     * 假如一个类 Person,有 id name 属性，我们根据id(模拟身份证号码)作为唯一标识，id不可以重复，name可以
     */
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Person person = PersonFactory.getPerson(ids[(int) (Math.random() * 5)]);
            person.setName(names[(int) (Math.random() * 5)]);
            System.out.println("第" + i + "个对象---" + person.toString());
        }
    }
}
