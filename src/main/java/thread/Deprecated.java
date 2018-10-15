package main.java.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Deprecated {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new PrintThread(),"PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        //暂停线程
        printThread.suspend();
        System.out.println("main suspend PrintThread at "+simpleDateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        //恢复线程
        printThread.resume();
        System.out.println("main resume PrintThread at "+simpleDateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        //终止线程
        printThread.stop();
        System.out.println("main stop PrintThread at "+simpleDateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);


    }

    static class PrintThread implements Runnable {
        @Override
        public void run() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            while (true){
                System.out.println(Thread.currentThread().getName() + "run at " + simpleDateFormat.format(new Date()));
                SleepUtil.second(1);
            }
        }
    }
}
