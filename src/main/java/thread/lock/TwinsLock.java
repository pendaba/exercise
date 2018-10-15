package main.java.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 同步器作为一个桥梁，连接线程访问以及同步状态控制等底层技术与不同并发组件（Lock,CountDownLatch）的接口语义
 */
public class TwinsLock implements Lock{
    private final Sync sync = new Sync(2);
    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private static final class Sync extends AbstractQueuedSynchronizer {

        Sync(int count){
            if(count <= 0){
                throw  new IllegalArgumentException("count must bigger than zero .");
            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int arg) {
           for(;;){
               int current = getState();
               //arg表示当前竞争同步状态的线程数量
               int newCount = current - arg;
               if(newCount < 0 || compareAndSetState(current,newCount)){
                   return newCount;
               }
           }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for(;;){
                int current = getState();
                //arg表示当前要释放同步状态的线程数量
                int newCount = current + arg;
                if(compareAndSetState(current,newCount)){
                    return true;
                }
            }
        }
    }

}
