package com.oman.forward.pattern.behavior.observer;

/**
 * @author:ZhouJiang
 * @date:2018/7/25 11:12
 * @email:zhoujiang2012@163.com
 */
public interface Subject {

    void register(IObserver observer);
    void unRegister(IObserver observer);
    void notifyObserver(String message);
}
