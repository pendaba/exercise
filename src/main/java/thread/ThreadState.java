package main.java.thread;


public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"TimeWaitingThrea").start();
        new Thread(new Waiting(),"WaitingThread").start();
        //两个blocked线程，一个会被阻塞
        new Thread(new Blocked(),"BlockedThread--1").start();
        new Thread(new Blocked(),"BlockedThread--2").start();
    }

    static class TimeWaiting implements Runnable {
        @Override
        public void run(){
            while(true){
                SleepUtil.second(100);
            }
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            while(true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable{
        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    SleepUtil.second(100);
                }
            }
        }
    }
}
