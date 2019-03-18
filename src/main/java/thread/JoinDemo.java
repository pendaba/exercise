package main.java.thread;

/**
 * @author fupengga
 * join() 方法当前线程会等待调用join方法的线程结束后才继续执行。
 */
public class JoinDemo {
    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for(int i=0;i<10;i++){
            Thread currentThread = new JoinThread(previousThread);
            currentThread.start();
            previousThread = currentThread;
        }
    }

    static class JoinThread extends Thread{
        private Thread thread;
        public JoinThread(Thread thread){
            this.thread = thread;
        }
        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName()+ "  terminated.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
