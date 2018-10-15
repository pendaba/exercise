package main.java.thread.executor;


import java.util.concurrent.*;

/**
 * executor框架属于用户级的调度框架，将应用程序分解为若干个任务，将任务映射为固定数量的线程。
 *
 * 两级调度模型：executor框架控制层的调度，操作系统内核的下层控制
 *
 * executor框架组成部分：1：任务，任务实现的接口：runnable，callable；   2：任务执行：executor,executorService接口，及其实现类；  3：计算结果：Future和FutureTask等实现类
 *
 * ThreadPoolExecutor:SingleThreadExecutor,FixedThreadPool,CachedThreadPool
 * ScheduledThreadPoolExecutor:ScheduledThreadPoolExecutor,SingleThreadPoolExecutor
 *
 * Future:
 *
 *
 *
 */
public class ExecutorTest {
    private ConcurrentHashMap<Object,Future<String>>  taskCache = new ConcurrentHashMap<>();
    private String executionTask(final  String taskName) throws ExecutionException,InterruptedException{
        while (true){
            Future<String> future = taskCache.get(taskName);
            if(future == null){
                Callable<String> task = new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return taskName;
                    }
                };
                FutureTask<String> futureTask = new FutureTask<>(task);
                future = taskCache.putIfAbsent(taskName,futureTask);
                if(future == null){
                    future = futureTask;
                    futureTask.run();
                }
            }
            try{
                return future.get();
            }catch (CancellationException e){
                taskCache.remove(taskName,future);
            }
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(new ExecutorTest().executionTask("aaa"));

    }
}