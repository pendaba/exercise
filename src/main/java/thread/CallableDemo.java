package main.java.thread;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future =  executorService.submit(() -> "callable线程");
        System.out.println(future.get());

//        ExecutorService service = Executors.newSingleThreadExecutor();
//        Future<String> future = service.submit(new Callable() {
//            @Override
//            public String call() throws Exception {
//                return "通过实现Callable接口";
//            }
//        });
//        try {
//            String result = future.get();
//            System.out.println(result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}
