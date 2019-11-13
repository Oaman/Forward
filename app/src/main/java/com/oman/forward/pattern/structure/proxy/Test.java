package com.oman.forward.pattern.structure.proxy;

public class Test {
    public static void main(String[] args){
        /**
         * 代理模式
         *      1 当需要扩展一些功能的时候，如果修改原有类的话就违反了OCP原则
         *      2 可以使用代理模式，实现同样的接口，在同样的方法中对齐前后处理，使之能控制结果
         */
        Sourceable source  = new Proxy();
        source.method();

        /**
         * 装饰者模式
         *      1 需要实现同样的接口
         *      2 并且装饰对象持有被装饰对象的实例，动态的为被装饰者添加一些功能
         *  缺点：
         *      产生过多的相似对象，不易排除问题
         */
//        Sourceable source2 = new Source();
//        Sourceable source3 = new Proxy(source2);
//        source3.method();

    }
}
