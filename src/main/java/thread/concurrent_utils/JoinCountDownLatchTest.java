package main.java.thread.concurrent_utils;

public class JoinCountDownLatchTest {
    public static void main(String[] args) throws Exception{
        Thread parse1 = new Thread(() -> System.out.println("parser1 finish"));
        Thread parser2 = new Thread(() -> System.out.println("parser2 finish"));
        parse1.start();
        parse1.start();
        parse1.join();
        parse1.join();
        System.out.println("all parser finish");

    }
}
