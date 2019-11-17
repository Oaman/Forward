package com.oman.forward.pattern.behavior.observer;

/**
 * @author:ZhouJiang
 * @date:2018/7/25 11:15
 * @email:zhoujiang2012@163.com
 */
public class Test {
    public static void main(String[] args){
        /**
         * 观察者模式：
         * 当我们订阅了一些文章之后，会受到推送的新消息，这是因为我们作为观察者，而订阅的文章作为被观察者，它更新会及时通知你
         *
         * 简单来说：就是当一个对象变化时候，其他依赖该对象的对象都会收到通知，并且随着变化，不牵扯到继承关系
         */
        IObserver observer1 = new Observer("张三");
        IObserver observer2= new Observer("李四");
        IObserver observer3 = new Observer("王五");

        Subject subject = new MySubject();
        subject.register(observer1);
        subject.register(observer2);
        subject.register(observer3);
        subject.notifyObserver("更新了新版本1.1的apk，大家下载使用啊");

        subject.unRegister(observer1);
        subject.notifyObserver("更新了新版本2.0的apk，大家下载使用啊");
    }
}
