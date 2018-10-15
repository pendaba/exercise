package main.java.thread;

import java.util.concurrent.TimeUnit;

public class SleepUtil {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
