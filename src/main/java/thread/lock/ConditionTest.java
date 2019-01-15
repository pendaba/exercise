package main.java.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fupengga
 * Condition方法试
 */
public class ConditionTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile boolean flag = false;
    static class Waiter implements Runnable{
        @Override
        public void run() {
            lock.lock();
            try {
                while (!flag){
                    System.out.println(Thread.currentThread().getName()+" 当前条件不满足等待中");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" 接收到通知条件满足");
            } finally {
                lock.unlock();
            }
        }
    }
    static class Signal implements Runnable{
        @Override
        public void run() {
            lock.lock();
            try {
                flag = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        /**
         * waiter线程开始执行时条件不满足，执行awaiter方法进入等待队列，释放锁。signal线程获取到锁后更改条件，唤醒所有等待线程，释放锁。这时waiter线程重新获取到锁，正常执行。
         */
         new Thread(new Waiter()).start();
         new Thread(new Signal()).start();

    }
}
