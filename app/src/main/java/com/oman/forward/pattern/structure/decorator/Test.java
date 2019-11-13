package com.oman.forward.pattern.structure.decorator;

public class Test {
    public static void main(String[] args) {
        /**
         * 装饰者模式要点：
         *      1 要将装饰者和被装饰者实现同样的接口
         *      2 装饰Decorator对象持有被装饰对象的实例，可以为Source类动态的扩展一些功能
         * 缺点：
         *      产生过多的相似对象，不易排除问题
         */
        Sourceable source = new Source();
        Decorator decorator  = new Decorator(source);
        decorator.method();
    }
}
