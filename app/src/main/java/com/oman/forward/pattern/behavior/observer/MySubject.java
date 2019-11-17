package com.oman.forward.pattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:ZhouJiang
 * @date:2018/7/25 11:13
 * @email:zhoujiang2012@163.com
 */
public class MySubject implements Subject {

    private List<IObserver> mObservers  = new ArrayList<>();
    @Override
    public void register(IObserver observer) {
        mObservers.add(observer);
    }

    @Override
    public void unRegister(IObserver observer) {
        mObservers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        System.out.println("自身收到了消息");
        for (IObserver observer:mObservers){
            observer.update(message);
        }
    }
}
