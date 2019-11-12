package com.oman.forward.pattern.structure.adapter;

public class Test {
    /**
     * 需求：首先需求是查询有三个游戏区的每个区的游戏玩家的数量  使用xml数据返回游戏区名称和数量
     * 使用Utils.getOnLinePlayCount(int region)
     *
     * 后来该需求因为一区的已经上线了，所以不能使用此API查询，使用的是ServiceFirst.getOnLinePlayCount();
     * 可以使用适配器模式：主要解决的紧急的任务,逻辑应该在ServiceOne中处理
     * 将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
     */
    public static void main(String[] args) {

        String serviceOne = XMLbuilder.buildXML(new ServiceOne());
        System.out.println("一区信息：\n" + serviceOne);

        String serviceTwo = XMLbuilder.buildXML(new ServiceTwo());
        System.out.println("二区信息：\n" + serviceTwo);

        String serviceThree = XMLbuilder.buildXML(new ServiceThree());
        System.out.println("三区信息：\n" + serviceThree);
    }
}
