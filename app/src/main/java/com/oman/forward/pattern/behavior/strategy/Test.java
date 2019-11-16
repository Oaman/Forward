package com.oman.forward.pattern.behavior.strategy;

public class Test {
    public static void main(String[] args) {
        /**
         * 需求:从数据库中查找给定姓名数组的人员的信息 此处主要演示的是字符串的拼接所采用的的策略模式
         *
         * 策略方法模式是可以被整体替换的算法
         *
         * 它定义了算法家庭，分别封装起来。让它们之间可以互相替换，此模式让算法的变化，不会影响到使用算法的客户。
         */
        String[] names = {"lucy", "jack", "cc"};
        QueryUtils.findUserInfo(names, new Strategy1());
        QueryUtils.findUserInfo(names, new Strategy2());
    }
}
