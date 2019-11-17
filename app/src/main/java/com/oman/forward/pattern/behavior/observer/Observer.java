package com.oman.forward.pattern.behavior.observer;

/**
 * @author:ZhouJiang
 * @date:2018/7/25 11:10
 * @email:zhoujiang2012@163.com
 */
public class Observer implements IObserver {
    private String name;

    public Observer(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name+"收到了消息"+message);
    }
}
