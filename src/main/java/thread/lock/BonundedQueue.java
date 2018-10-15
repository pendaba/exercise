package main.java.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BonundedQueue<T>{

    private Object[] items;
    //插入下标位置，删除下标位置，已插入元素数量
    //addIndex,removeIndex为0时表示无法进行入队和出队操作
    private int addIndex,removeIndex,count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BonundedQueue(int size){
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try{
            //这里和下面的删除方法使用while循环，目的是防止过早或意外的通知，只有条件符合时才能够退出循环
            while (count == items.length){
                notFull.await();
            }
            items[addIndex] = t;
            if(++addIndex == items.length){
                //队列满了之后，？？？？
                addIndex = 0;
            }
            count++;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try{
            while (count == 0) {
                notEmpty.await();
            }
            Object removeItem = items[removeIndex];
            if(++removeIndex == items.length){
                removeIndex = 0;
            }
            --count;
            notFull.signal();
            return (T) removeItem;
        }finally {
            lock.unlock();
        }
    }


}
