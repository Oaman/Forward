package com.oman.forward.pattern.behavior.chain;

/**
 * @author:ZhouJiang
 * @date:2019/11/17 12:22
 * @email:zhoujiang2012@163.com
 */
public class AbstractHandler {
    private Handler mHandler;

    public Handler getHandler() {
        return mHandler;
    }

    public void setHandler(Handler handler) {
        mHandler = handler;
    }
}
