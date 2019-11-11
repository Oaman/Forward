package com.oman.forward.pattern.create.builder;


/**
 * @author:ZhouJiang
 * @date:2019/11/11 23:02
 * @email:zhoujiang2012@163.com
 */
public abstract class Builder {

    /**
     * Builder:抽象创建者角色，这是一个将复杂对象的创建过程抽象化的一个接口，
     * 它规范了对象的各个部分的创建，规定了要实现复杂对象的哪个部分的创建，但是不涉及具体对象的创建。
     */
    protected abstract void buildPartA();

    protected abstract void buildPartB();

    protected abstract void buildPartC();

    protected abstract Product getResult();
}
