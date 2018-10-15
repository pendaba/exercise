package main.java.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {
    public static void main(String[] args) {
        Person a = new Person(12,"aa",24);
        Person b = new Person(13,"bb",24);
        Person c = new Person(14,"cc",24);
        Person d = new Person(12,"dd",24);
        List<Person> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.stream().mapToInt(person -> person.getHeight()).distinct().forEach(System.out :: println);
        System.out.println( list.stream().mapToInt(person -> person.getHeight()).distinct().count());
    }
}
