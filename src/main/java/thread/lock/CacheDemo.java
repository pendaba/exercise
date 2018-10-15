package main.java.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁的使用方式演示
 *
 * reentrantReadWriteLock的实现：读写状态的设计，写锁的获取与释放，读锁的获取与释放，锁降级
 */
public class CacheDemo {
    static Map<String,Object> map = new HashMap<>();
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock readLock = lock.readLock();
    static Lock writeLock = lock.writeLock();

    public static final Object get(String key) {
        readLock.lock();
        try{
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public static final Object put(String key,Object value){
        writeLock.lock();
        try{
            return map.put(key,value);
        }finally {
            writeLock.unlock();

        }
    }

    public static final void clear() {
        writeLock.lock();
        try{
            map.clear();
        }finally {
            writeLock.unlock();
        }
    }

}
