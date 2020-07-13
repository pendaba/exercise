package main.java.thread.practice;

import main.java.java8.entity.Track;

public class TicketTest {

    //    线程交替打印两个数组的内容
    public int[] ints = new int[]{1, 2, 3, 4, 5};
    public char[] chars = new char[]{'a', 'b', 'c', 'd', 'e'};
    public volatile boolean flag = true;
    public int[] lock = new int[0];

    public void test() {
        new Thread(new MyRunner1(), "线程1").start();
        new Thread(new MyRunner2(), "线程2").start();
    }

    public static void main(String[] args) {
        new TicketTest().test();
    }

    class MyRunner1 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < ints.length; i++) {
                    if (!flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ints[i]);
                    flag = false;
                    lock.notifyAll();
                }
            }
        }
    }

    class MyRunner2 implements Runnable {
        @Override
        public void run() {

            synchronized (lock) {
                for (int i = 0; i < chars.length; i++) {
                    if (flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + chars[i]);
                    flag = true;
                    lock.notifyAll();
                }
            }

        }
    }
}