package main.java.map;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashmapTest {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
//        System.out.println(1<<4);
//        System.out.println(2^3);
        System.out.println(tableSizeFor(28285858));

    }
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
