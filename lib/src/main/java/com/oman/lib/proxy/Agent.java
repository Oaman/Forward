package com.oman.lib.proxy;

/**
 * @author:ZhouJiang
 * @date:2020/5/17 22:27
 * @email:zhoujiang2012@163.com
 */
public class Agent implements Service {
    private Service mService;

    public Agent() {
    }

    @Override
    public void service(int time) {
        beforeService();
        if (mService == null) {
            mService = new WashService();
        }
        mService.service(time);
        afterService();
    }

    private void beforeService() {
        System.out.println("before service");
    }

    private void afterService() {
        System.out.println("after service");
    }
}
