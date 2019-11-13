package com.oman.forward.pattern.structure.proxy;

public class Proxy implements Sourceable {

//    /**
//     * 装饰者模式
//     */
//    private Sourceable source;
//
//    public Proxy(Sourceable source) {
//        this.source = source;
//    }

    private Sourceable source;

    /**
     * 代理模式   代理模式就类似于生活中找中介，找律师一样作为中介
     * 此处如果设置为有参构造方法的话就和装饰者模式一样了
     *
     * 代理模式的应用场景：
     *      如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法：
     *      1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。
     *      2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。
     * 使用代理模式，可以将功能划分的更加清晰，有助于后期维护！
     */
    public Proxy() {
        source = new Source();
    }

    @Override
    public void method() {
        beforeMethod();
        source.method();
        afterMethod();
    }

    private void beforeMethod() {
        System.out.println("before proxy");
    }

    private void afterMethod() {
        System.out.println("after proxy");
    }
}
