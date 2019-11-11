package com.oman.forward.pattern.create.builder;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 23:05
 * @email:zhoujiang2012@163.com
 */

public class BuilderA extends Builder {
    /**
     * ConcreateBuilder:具体创建者角色，它实现了Builder接口，具体化对象的创建过程，最后返回一个对象的实例
     */
    private Product product = new Product();

    @Override
    protected void buildPartA() {
        product.add("partA");
    }

    @Override
    protected void buildPartB() {
        product.add("partB");
    }

    @Override
    protected void buildPartC() {
        product.add("partC");
    }

    @Override
    protected Product getResult() {
        return product;
    }
}
