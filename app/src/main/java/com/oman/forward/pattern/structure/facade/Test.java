package com.oman.forward.pattern.structure.facade;

/**
 * @author:ZhouJiang
 * @date:2019/11/14 09:13
 * @email:zhoujiang2012@163.com
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 外观模式
         *      如果没有Computer类的话，那么其余三个类之间肯定会相互持有对象实例，有很大的耦合性，修改一个会对其余的造成影响
         *      有了Computer类之后，就将他们彼此之间的关系放在了Computer类中了，大大降低了系统的耦合性，实现高内聚低耦合
         */
        Computer computer = new Computer();
        computer.startWork();
        System.out.println("------------------");
        computer.stopWork();
    }
}
