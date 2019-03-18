package main.java.thread;

/**
 * @author fupengga
 *
 */
public class ThreadLocalTest {
    ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    static ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
    public void set(){
        stringThreadLocal.set(Thread.currentThread().getName());
    }
    public String getString(){
        return stringThreadLocal.get();
    }
    public static void main(String[] args) {
        /**
         * 1. threadlocals默认初始化的value是null,因此使用TheadLocal时要先set再get,ThreadLocal的initialValue方法是可以在创建对象的时候重写的
         * 2. 线程通过ThreadLocal类进行缓存自己的本地变量，以空间换时间
         * 3. 每个线程都可以有很多个ThreadLocal实例来存储自己的本地变量
         * 4. ThreadLocal常见的使用场景是解决数据库连接，session,request等
         */
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.set();
        longThreadLocal.set(100L);
        System.out.println(threadLocalTest.getString());
        System.out.println(longThreadLocal.get());
        Thread A = new Thread(() ->{
            threadLocalTest.set();
            longThreadLocal.set(200L);
            System.out.println(threadLocalTest.getString());
            System.out.println(longThreadLocal.get());
        });

        A.start();
        try {
            A.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadLocalTest.getString());
        System.out.println(longThreadLocal.get());
    }
}
