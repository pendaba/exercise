package main.java.thread.concurrent_container;


import java.util.concurrent.*;

public class CounTask extends RecursiveTask<Integer> {
    private static  final int THRESHOLD = 50;
    private int start;
    private int end;
    public CounTask(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end-start) <= THRESHOLD;
        //如果任务大于阈值，就分裂成两个子任务计算
        if(canCompute){
            for(int i =start; i <= end; i++){
                sum += i ;
            }
        }else{
            //如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) /2;
            CounTask leftTask = new CounTask(start,middle);
            CounTask rightTask = new CounTask(middle + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完毕，获得结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CounTask counTask = new CounTask(1,100);
        Future<Integer> result = forkJoinPool.submit(counTask);
        try{
            System.out.println(result.get());
        }catch (InterruptedException e){

        }catch (ExecutionException e ) {

        }
    }
}
