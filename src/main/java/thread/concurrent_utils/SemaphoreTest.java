package main.java.thread.concurrent_utils;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author fupengga
 * Semaphore是用来控制同时访问特定资源的线程数量。
 * 我们来模拟这样一样场景。有一天，班主任需要班上10个同学到讲台上来填写一个表格，但是老师只准备了5支笔，
 * 因此，只能保证同时只有5个同学能够拿到笔并填写表格，没有获取到笔的同学只能够等前面的同学用完之后，才能拿到笔去填写表格。
 */
public class SemaphoreTest {
    //模拟老师只有5支笔
    private static Semaphore semaphore = new Semaphore(5);

    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
       for(int i=0;i<10;i++){
           threadPool.execute(() -> {
               try {
                   System.out.println(Thread.currentThread().getName() + "  同学准备获取笔......");
                   semaphore.acquire();
                   System.out.println(Thread.currentThread().getName() + "  同学获取到笔");
                   System.out.println(Thread.currentThread().getName() + "  填写表格ing.....");
                   TimeUnit.SECONDS.sleep(3);
                   semaphore.release();
                   System.out.println(Thread.currentThread().getName() + "  填写完表格，归还了笔！！！！！！");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           });
       }
        threadPool.shutdown();
    }
}
