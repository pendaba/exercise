package main.java.thread.concurrent_container;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {


    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
        System.out.println(map.size());


    }
}
