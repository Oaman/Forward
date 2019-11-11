package com.oman.forward.pattern.create.builder;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 23:05
 * @email:zhoujiang2012@163.com
 */
public class BuilderTest {
    public static void main(String[] args) {
        /**
         * 使用建造者模式的好处
         *
         *  a)使用建造者模式可以不用让客户端知道产品内部的创建细节
         *
         *  b)具体的建造者类之间是相互独立的，这样有利于系统的扩展
         *
         *  c)具体的建造者之间相互独立可以对建造的过程逐步细化，而不会对其他模块产生任何影响
         */
        BuilderDirector director = new BuilderDirector(new BuilderA());
        Product product = director.build();
        product.show();
    }
}
