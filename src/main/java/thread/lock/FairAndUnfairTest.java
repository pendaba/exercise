package main.java.thread.lock;




import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairTest {

    private static ReentrantLock2 fairLock = new ReentrantLock2(true);
    private static ReentrantLock2 unfairLock = new ReentrantLock2(false);

    private static final class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair){
            super(fair);
        }
        public Collection<Thread> getQueuedThreads(){
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }

    }

    private static class Job extends Thread {
        private ReentrantLock2 lock;
        public Job(ReentrantLock2 lock){
            this.lock = lock;
        }

        @Override
        public void run() {
          System.out.println(Thread.currentThread().getName()+"==="+lock.getQueuedThreads().toString());
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i<5; i++){
            new Job(fairLock).start();
//        new Job(unfairLock).start();
        }

    }
}
