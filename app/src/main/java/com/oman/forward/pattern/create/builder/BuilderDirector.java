package com.oman.forward.pattern.create.builder;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 23:05
 * @email:zhoujiang2012@163.com
 */
public class BuilderDirector {
    /**
     * Director:构造一个使用Builder接口的对象，指导整个构建过程；不涉及具体的产品信息，
     * 只负责对象的各个部分完整创建或者按照某种顺序创建
     */
    private Builder builder;

    public BuilderDirector(Builder builder) {
        this.builder = builder;
    }

    public Product build() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
