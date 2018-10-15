package main.java.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    static int[] intArr = new int[]{1,2,3};
    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(intArr);
    public static void main(String[] args) {
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.getAndSet(5));
        System.out.println(atomicInteger.get());
        System.out.println("========atomicIntegerArray=========");
        System.out.println(atomicIntegerArray.addAndGet(0,2));
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(intArr[0]);
        System.out.println(atomicIntegerArray.compareAndSet(0,3,30));
        System.out.println(atomicIntegerArray.get(0));



    }
}
