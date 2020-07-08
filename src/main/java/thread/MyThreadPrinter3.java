package main.java.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPrinter3 {

    static String[] strings = new String[]{"a", "b", "c", "d", "e", "f"};
    static int[] ints = new int[]{1, 2, 3, 4, 5, 6};
    public static volatile boolean flag = true;
    static Object o = new Object();
    public static AtomicInteger i = new AtomicInteger(0);
    public static AtomicInteger j = new AtomicInteger(0);



    static class Printer1 implements Runnable {
        @Override
        public void run() {

            for (i.get(); i.get() < 6; i.getAndIncrement()) {
                synchronized (o) {
                    if (!flag) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(strings[i.get()]);
                    o.notifyAll();
                    flag = false;
                }

            }
        }
    }

    static class Printer2 implements Runnable {
        @Override
        public void run() {

            for (j.get(); j.get() < 6; j.getAndIncrement()) {
                synchronized (o) {
                    if (flag) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(ints[j.get()]);
                    o.notifyAll();
                    flag = false;
                }

            }
        }

    }

    public static void main(String[] args) {
        final Object obj = new Object();
        char[] number = {'1','2','3','4','5','6','7','8','9'};
        char[] letter = {'A','B','C','D','E','F','G','H','I'};

        new Thread(() -> {
            synchronized (obj){
                for(char num : number){
                    System.out.print(num + " ");
                    try {
                        obj.notify(); //叫醒其他线程，这里就是t2
                        obj.wait(); //让自己阻塞，让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify(); //必须要有，因为两个线程的try里面的最后一步是阻塞，如果线程执行完了还在阻塞肯定不对，必须要唤醒，才能正确结束程序
            }
        }).start();

        new Thread(() -> {
            synchronized (obj){
                for(char let : letter){
                    System.out.print(let + " ");
                    try {
                        obj.notify(); //叫醒其他线程，这里是t1
                        obj.wait(); //让自己阻塞，让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify(); //同上
            }
        }).start();

    }




}
