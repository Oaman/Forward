package com.oman.forward.pattern.behavior.chain;

/**
 * @author:ZhouJiang
 * @date:2019/11/17 12:24
 * @email:zhoujiang2012@163.com
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 责任链模式:
         *      有多个对象，每个对象会持有下一个对象的引用，这样的话就会形成一个链，请求在链上传递，
         *      直到某一个对象处理此请求 但是发出者并不清楚哪个会处理此事件
         *
         * AbstractHandler提供了get set方法,MyHandler继承AbstractHandler提供了get，实现Handler，里面会形成一条链
         *   链接上的请求可以是一条链，可以是一个树，还可以是一个环，模式本身不约束这个，需要我们自己去实现，
         *   同时，在一个时刻，命令只允许由一个对象传给另一个对象，而不允许传给多个对象
         */
        MyHandler handler1= new MyHandler("handler1");
        MyHandler handler2= new MyHandler("handler2");
        MyHandler handler3= new MyHandler("handler3");

        handler1.setHandler(handler2);
        handler2.setHandler(handler3);
        handler1.handle();
    }
}
