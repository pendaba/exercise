package main.java.thread;

public class DaemonDemo {
    public static void main(String[] args) {
        Thread deamonThread = new Thread(() -> {
            while (true){
                try {
                    System.out.println(" I am alive");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(" finally block");
                }
            }
        });
        deamonThread.setDaemon(true);
        deamonThread.start();
        //确保main线程结束前能给daemonThread能够分到时间片
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
