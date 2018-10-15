package main.java.thread;

public class MyThread extends Thread{
    private String name;
    public MyThread(String name) {
        this.name=name;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("线程1");
        MyThread myThread2 = new MyThread("线程2");
        myThread1.start();
        myThread2.start();
    }
    
    
    
}
