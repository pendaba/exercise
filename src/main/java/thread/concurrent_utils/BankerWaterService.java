package main.java.thread.concurrent_utils;

import java.util.Map;
import java.util.concurrent.*;

public class BankerWaterService implements Runnable{
    private CyclicBarrier c = new CyclicBarrier(4,this);
    //启动4个线程
    private Executor executor = Executors.newFixedThreadPool(4);
    //保存结果
    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<>();
    private void count(){
        for(int i = 0;i < 4; i++){
            executor.execute(() ->
            {
                sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for(Map.Entry<String,Integer> sheet : sheetBankWaterCount.entrySet()){
            result += sheet.getValue();
        }
        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankerWaterService bankerWaterService = new BankerWaterService();
        bankerWaterService.count();
    }
}
