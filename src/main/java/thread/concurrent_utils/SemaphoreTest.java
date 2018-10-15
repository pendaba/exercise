package main.java.thread.concurrent_utils;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore是用来控制同时访问特定资源的线程数量。
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static Semaphore semaphore = new Semaphore(10);
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {
        for(int i = 0; i < THREAD_COUNT; i++){
            threadPool.execute(() ->
            {
                try {
                    semaphore.acquire();
                    System.out.println("save data"+"||"+Thread.currentThread().getName());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }
}
