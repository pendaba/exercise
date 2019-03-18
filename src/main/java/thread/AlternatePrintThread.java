package main.java.thread;


/**
 * @author fupengga
 * 线程交替打印
 */
public class AlternatePrintThread {
    private static int count = 1;
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        PrintThread  A = new PrintThread(c,a);
        PrintThread  B = new PrintThread(a,b);
        PrintThread  C = new PrintThread(b,c);
        new Thread(A,"thread-1").start();
        new Thread(B,"thread-2").start();
        Thread.sleep(10);
        new Thread(C,"thread-3").start();
        Thread.sleep(10);

    }

    static  class PrintThread implements Runnable {
        Object previous;
        Object self;

        PrintThread(Object previous, Object self) {
            this.previous = previous;
            this.self = self;
        }

        @Override
        public void run() {
            while (count <= 100){
                synchronized (previous){
                    synchronized (self){
                        System.out.println(Thread.currentThread().getName()+":  "+ count++);
                        self.notifyAll();
                    }
                    try {
                        previous.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

}
