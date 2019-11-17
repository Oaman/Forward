package com.oman.forward.pattern.behavior.chain;

/**
 * @author:ZhouJiang
 * @date:2019/11/17 12:23
 * @email:zhoujiang2012@163.com
 */
public class MyHandler extends AbstractHandler implements Handler {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void handle() {
        System.out.println(name + "--handler...");
        if (getHandler() != null) {
            getHandler().handle();
        }
    }
}
