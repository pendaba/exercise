package main.java.thread.concurrent_utils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger是一个用于线程间协作的工具类。它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() ->
        {
            try {
                String A = "流水";
                exgr.exchange(A);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        threadPool.execute(() ->
        {

            try {
                String B = "流水";
                String A = exgr.exchange(B);
                System.out.println("A和B的数据是否一致："+ A.equals(B)+",A录入的是："+A+",B录入的是："+B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        threadPool.shutdown();
    }
}
