package main.java.thread.volatiledemo;

public class VolatileFeaturesExample {
    volatile long v1 = 0l;
    public static final int a = 6;
    public void set(long l){
        v1 = l;
    }
    public void getAndIncrement(){
        v1++;
    }
    public long get(){
        return v1;
    }
    public void describe(){
        int b = a + 3 ;
        System.out.println(b);
    }

    public static void main(String[] args) {
        new VolatileFeaturesExample().describe();
    }
}
