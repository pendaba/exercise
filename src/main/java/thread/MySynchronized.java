package main.java.thread;

public class MySynchronized {
    public static void main(String[] args) {
        synchronized (MySynchronized.class){

        }
        m();
    }
    public static synchronized void m(){

    }

}
