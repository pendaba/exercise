package main.java.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa","bb");
        List<String> list1 = Arrays.asList("cc","dd","11");
        System.out.println(Stream.of(list,list1).flatMap(lists -> lists.stream()).sorted().collect(Collectors.toList()));

        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println( predicate instanceof  Object);

        //字符串操作
        String  s = "asfsdfhfeRterbvnbnrtyjjhaantryrewrwvv";
        Long countOfa = s.chars().filter( cha -> cha == 'a').count();
        System.out.println(countOfa);


    }
}
