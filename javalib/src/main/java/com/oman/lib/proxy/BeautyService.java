package com.oman.lib.proxy;

/**
 * @author:ZhouJiang
 * @date:2020/5/17 22:26
 * @email:zhoujiang2012@163.com
 */
public class BeautyService implements Service {
    @Override
    public void service(int time) {
        System.out.println("beauty wash service:" + time+" minutes");
    }
}
