package main.java.thread.connectionpool;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {
    static ConnectionPool pool  = new ConnectionPool(10);
    //保证所有connectionrunner能够同时开始
    static CountDownLatch start = new CountDownLatch(1);
    //main线程会等待多有connectionrunner结束后才能继续执行
    static CountDownLatch end;
    public static void main(String[] args) throws Exception{
        int threadCount = 50;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger noGot = new AtomicInteger();
        for(int i = 0;i<threadCount; i++){
            Thread thread = new Thread(new ConnectionRunner(count,got,noGot),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " + (threadCount*count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + noGot);

    }
    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger noGot;
        public ConnectionRunner(int count,AtomicInteger got,AtomicInteger noGot){
            this.count = count;
            this.got = got;
            this.noGot = noGot;
        }
        @Override
        public void run() {
            try{
                start.await();
            }catch (Exception e){
                e.printStackTrace();
            }
            while (count > 0 ){
                try{
                    // 从线程中获取连接，如果1000ms内无法获取到返回null
                    // 分别统计获取连接的数量got和未获取的数量 noGot
                    Connection connection = pool.fetchConnection(1000);
                    if(connection != null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else{
                        noGot.incrementAndGet();
                    }
                }catch (Exception e ){
                    e.printStackTrace();
                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
