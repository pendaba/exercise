package main.java.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    private int a = 1;

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(2000);
        System.out.println(map.size());
        map.put("aa", 1);
        map.put("bb", "cccc");
        System.out.println(map.size());
        System.out.println(map.get("aa").equals(1));
    }

    public MapTest print() {
        this.a = 3;
        System.out.println(a);
        this.print11();
        return this;
    }

    public void print11() {
        a = 5;
        System.out.println(a);

    }
}
