package com.oman.lib.jdk;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author:ZhouJiang
 * @date:2020/5/18 22:18
 * @email:zhoujiang2012@163.com
 */
public class OnlyMain {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        /**
         * [5] Attach Listener
         * [4] Signal Dispatcher
         * [3] Finalizer
         * [2] Reference Handler
         * [1] main
         *
         * GC 并不是马上就会有GC，资源需要回收，JVM才会检测到，启用GC
         */
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + " "
                    + threadInfo.getThreadName());
        }

    }
}
