package com.oman.lib.jdk;

/**
 * @author:ZhouJiang
 * @date:2020/4/21 23:41
 * @email:zhoujiang2012@163.com
 */
public class TestReference {
    public static void main(String[] args) {
        Reference reference = new Reference();
        Reference reference2 = new Reference();
        reference.mObject = reference2;
        reference2.mObject = reference;
        reference = null;
        reference2 = null;
        System.gc();
    }

    static class Reference {
        public Object mObject = null;
        private byte[] data = new byte[2 * 1024 * 1024];
    }

}
