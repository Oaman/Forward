package com.oman.forward.pattern.behavior.visitor;

public class Test {
    public static void main(String[] args){
        /**
         * 如果我们将类增加新功能,会考虑到如下问题：
         *      1 新功能的兼容性
         *      2 以后会不会需要添加
         *      3 如果类不能修改代码怎么办？
         * 访问者模式：
         *      把数据结构和作用于结构上的操作解耦
         *      访问者模式适用于数据结构相对稳定的系统，把数据结构和算法解耦
         */

        IVisitor visitor = new Visitor();
        ISubject subject = new Subject();
        subject.accept(visitor);
    }
}
