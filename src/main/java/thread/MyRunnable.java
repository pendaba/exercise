package main.java.thread;

public class MyRunnable implements Runnable{
    private int count = 20;
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行  :  " + count--);
            try {
                Thread.sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable,"A").start();
        new Thread(myRunnable,"B").start();
        new Thread(myRunnable,"C").start();
        new Thread(myRunnable,"D").start();

    }
}
