package main.java.thread.concurrent_utils;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException{
        Thread parse1 = new Thread(() ->
            {
                System.out.println(1);
                countDownLatch.countDown();
                System.out.println(2);
                countDownLatch.countDown();
            }
        );
        parse1.start();
        countDownLatch.await();
        System.out.println(3);
    }
}
