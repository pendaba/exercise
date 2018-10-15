package main.java.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 *
 */
public class AtomicReferenceDemo {
    public static AtomicReference<User> atomicUser = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("tom",18);
        atomicUser.set(user);
        User updateUser = new User("Jack",20);
        atomicUser.compareAndSet(user,updateUser);
        System.out.println(atomicUser.get().getName());
        System.out.println(atomicUser.get().getAge());
    }
}
