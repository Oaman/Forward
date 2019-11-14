package com.oman.forward.pattern.structure.facade;

/**
 * @author:ZhouJiang
 * @date:2019/11/13 09:24
 * @email:zhoujiang2012@163.com
 */
public class Mouse implements IControl {
    @Override
    public void startWork() {
        System.out.println("Mouse start work");
    }

    @Override
    public void stopWork() {
        System.out.println("Mouse stop work");
    }
}
