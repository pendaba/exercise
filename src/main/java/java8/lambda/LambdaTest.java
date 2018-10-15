package main.java.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {

    static int outerStaticNum;
    int outerNum;

    public static void main(String[] args) {
//        Runnable r1 = () -> {System.out.println("Hello Lambda!");};
//        System.out.print(r1.toString());
//        Object o = (Runnable) () -> { System.out.println("hi"); }; // correct
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aadc");
        list.add("bbb");
        list.add("ccc");
        list.stream().filter(s -> s.length() == 3).map(s -> s.replace("aa","nn")).sorted().forEach(o -> System.out.println(o));
    }
//    访问成员变量和静态变量
//    与局部变量不同，我们在lambda表达式的内部能获取到对成员变量或静态变量的读写权。这种访问行为在匿名对象里是非常典型的。

}
