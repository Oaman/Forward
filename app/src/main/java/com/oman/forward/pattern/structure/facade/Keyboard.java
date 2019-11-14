package com.oman.forward.pattern.structure.facade;

/**
 * @author:ZhouJiang
 * @date:2019/11/13 09:24
 * @email:zhoujiang2012@163.com
 */
public class Keyboard implements IControl {
    @Override
    public void startWork() {
        System.out.println("Keyboard start work");
    }

    @Override
    public void stopWork() {
        System.out.println("Keyboard stop work");
    }
}
