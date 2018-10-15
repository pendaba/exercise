package main.java.java8.lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceTest {

    public static void main(String[] args) {
//        predicateTest();
//        System.out.println(functionsTest());
//        converterTest();
//        supplierTest();
        comparatorTest();
    }
    //    Predicate是一个布尔类型的函数，该函数只有一个输入参数。Predicate接口包含了多种默认方法，用于处理复杂的逻辑动词（and, or，negate）
    public static void predicateTest(){
        Predicate<String> predicate = (s) -> s.length() > 0;
        Predicate<String> b = (s) -> s.length() < 2 ;
        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        System.out.println( predicate.and(b).test("fdfd"));
        System.out.println( predicate.negate().test("foo"));
        System.out.println( "=============");
        System.out.println( nonNull);
        System.out.println( isNull);

    }
//    Function接口接收一个参数，并返回单一的结果。默认方法可以将多个函数串在一起（compse, andThen）
    public static String  functionsTest(){
        Function<String,Integer> toInteger = Integer::valueOf;
        System.out.println(toInteger.apply("12312"));
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        return backToString.apply("123");     // "123"
    }
//    Supplier接口产生一个给定类型的结果。与Function不同的是，Supplier没有输入参数。
    public static void supplierTest(){
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person

    }
//    自定义接口Converter测试
    public static void converterTest(){
        Converter<String, Integer> converter =Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

    }

//    Consumer代表了在一个输入参数上需要进行的操作。
    public  static void consumerTest(){
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getName());
        greeter.accept(new Person(154,"Luke", 20));

    }
    public static void comparatorTest(){
        Comparator<Person> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());

        Person xiaoming = new Person(175,"xiaoming",70);
        Person xiaowang = new Person(180,"xiaoming",75);

       System.out.println(comparator.compare(xiaoming, xiaowang));              // > 0
       System.out.println(comparator.reversed().compare(xiaoming, xiaowang) ); // < 0
    }

//    Optional是一个简单的值容器，这个值可以是null，也可以是non-null。考虑到一个方法可能会返回一个non-null的值，也可能返回一个空值。为了不直接返回null，我们在Java 8中就返回一个Optional.
    public static void optionalTest(){
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }


}
