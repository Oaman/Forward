package com.oman.lib.proxy;

/**
 * @author:ZhouJiang
 * @date:2020/5/17 22:26
 * @email:zhoujiang2012@163.com
 */
public class WashService implements Service {
    @Override
    public void service(int time) {
        System.out.println("provide wash service:" + time+" minutes");
    }
}
