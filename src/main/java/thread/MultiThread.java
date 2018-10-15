package main.java.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        Arrays.stream(threadInfos).forEach(threadInfo -> System.out.println("["+threadInfo.getThreadId()+"]"+threadInfo.getThreadName()));
        /**
         * [5]Monitor Ctrl-Break
         *[4]Signal Dispatcher 分发处理发送费jvm信号的线程
         *[3]Finalizer    调用finalize的线程
         *[2]Reference Handler 清除reference的线程
         *[1]main main线程，用户程序入口
         */
    }
}
