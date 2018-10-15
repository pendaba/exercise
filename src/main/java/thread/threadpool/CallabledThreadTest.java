package main.java.thread.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallabledThreadTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(; i<100; i++){
            System.out.println(Thread.currentThread().getName()+" "+i);

        }
        return i;
    }

    public static void main(String[] args) {
        CallabledThreadTest callabledThreadTest = new CallabledThreadTest();
        FutureTask<Integer> futureTask = new FutureTask<>(callabledThreadTest);
        for(int i=0; i<100; i++){
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值："+i);
            if(i == 20){
                new Thread(futureTask,"有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值："+ futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
