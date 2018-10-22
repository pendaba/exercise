package main.java.thread.synchronize;



/**
 * @author fupengga
 */
public class SynchronizedDemo {
    public static Integer count = 0;
    public static String a = "sdfd";

    public static void main(String[] args) {
        for(int i = 0;i< 10;i++){
            new Thread(()->{
                synchronized (SynchronizedDemo.a){
                    for(int j=0;j<10000;j++){
                        count++;
                    }
                }
            }).start();
        }


        try {
//            主线程需要等待子线程结束
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

}
