package main.java.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collectiontest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(4);
        list.add(1);
        System.out.println(list.size());
        for (int i = 2; i<8; i++){
            list.add(i);
        }
        System.out.println(list.size());

        System.out.println( 0.1 * 3 == 0.3);

        List<Integer> integers = new LinkedList<>();

        System.out.println((int)(1*0.75));
    }
}
