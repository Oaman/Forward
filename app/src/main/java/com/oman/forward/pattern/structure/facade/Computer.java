package com.oman.forward.pattern.structure.facade;

/**
 * @author:ZhouJiang
 * @date:2019/11/13 09:26
 * @email:zhoujiang2012@163.com
 */
public class Computer implements IControl {

    private Keyboard mKeyboard;
    private Mouse mMouse;
    private Screen mScreen;

    public Computer() {
        mKeyboard = new Keyboard();
        mMouse = new Mouse();
        mScreen = new Screen();
    }

    @Override
    public void startWork() {
        System.out.println("computer start work");
        mScreen.startWork();
        mKeyboard.startWork();
        mMouse.startWork();
    }

    @Override
    public void stopWork() {
        System.out.println("computer stop work");
        mScreen.stopWork();
        mKeyboard.stopWork();
        mMouse.stopWork();
    }
}
