package com.oman.forward.pattern.behavior.iterator;

/**
 * @author:ZhouJiang
 * @date:2019/11/17 11:01
 * @email:zhoujiang2012@163.com
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 迭代器模式：自己写的一个迭代器对象
         *      主要就是顺序访问集合中的对象
         *  1 需要遍历的对象 即聚集对象
         *  2 使用迭代器对象用于对聚集对象遍历
         */
        Collection<String> collection = new MyCollection<>(new String[]{"A", "B", "C", "D"});
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
