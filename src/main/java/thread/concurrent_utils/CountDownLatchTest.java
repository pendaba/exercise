package main.java.thread.concurrent_utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fupengga
 * 倒计时器测试
 * 使用场景：多线程协作完成任务时，有时候需要等待其他多个线程完成任务之后，主线程才能继续往下执行业务，可是使用join方法也可以使用CountDownLatch。
    构造方法：
    public CountDownLatch(int count)
    构造方法会传入一个整型数N，之后调用CountDownLatch的countDown方法会对N减一，知道N减到0的时候，当前调用await方法的线程继续执行。
    主要方法介绍：
        1 await() throws InterruptedException：调用该方法的线程等到构造方法传入的N减到0的时候，才能继续往下执行；
        2 await(long timeout, TimeUnit unit)：与上面的await方法功能一致，只不过这里有了时间限制，调用该方法的线程等到指定的timeout时间后，不管N是否减至为0，都会继续往下执行；
        3 countDown()：使CountDownLatch初始值N减1；
        4 long getCount()：获取当前CountDownLatch维护的值；
 */
public class CountDownLatchTest {
    private static CountDownLatch startSignal = new CountDownLatch(1);

    private static CountDownLatch endSignal = new CountDownLatch(6);


    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for(int i = 0;i < 6; i++){
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 运动员等待裁判员吹哨！！");
                    startSignal.await();
                    System.out.println(Thread.currentThread().getName() + " 运动员正在全力冲刺！！");
                    System.out.println(Thread.currentThread().getName() + " 运动员到达终点！！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    endSignal.countDown();
                }
            });
        }
        Thread.sleep(500);
        System.out.println("裁判员发号命令了！！！");
        startSignal.countDown();
        endSignal.await();
        System.out.println("所有运动员到达终点，比赛结束！！");
        executorService.shutdown();


    }
}
