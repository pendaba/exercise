package main.java.java8.optional;

import java.util.Optional;

/**
 * @author fupengga
 */
public class OptionalTest {

    public static void main(String[] args) {

        System.out.println("===================");
        //of 创建一个optional
        Optional<String> name = Optional.of("chunfeng");

        //返回一个不包含任何值的实例
        Optional empty = Optional.ofNullable(null);

        name.ifPresent(System.out::println);
        name.ifPresent(a -> System.out.println(a));

        //第二个同类型的 API 是 orElseGet() —— 其行为略有不同。这个方法会在有值的时候返回值，如果没有值，它会执行作为参数传入的 Supplier(供应者) 函数式接口，并将返回其执行结果：
        //区别orElse在有默认值时也会执行oreElse里面的方法
        System.out.println("=======orElseGet()与orElse()测试 ============");
        User user = new User();
        System.out.println(getName(user));
        user.setName("chunfeng123");
        user.setAge(20);
        System.out.println(getName(user));
        System.out.println(Optional.ofNullable(new User().getName()).orElseGet(() -> user.getName()));
        //它会在对象为空的时候抛出异常
//        Optional.ofNullable(null).orElseThrow(() -> new NullPointerException());

        System.out.println("=======map()与flatMap()测试======");
        System.out.println(Optional.ofNullable(user).map(u -> u.getName()).orElse("unknown"));
        System.out.println(Optional.ofNullable(user).flatMap(u -> Optional.ofNullable(u.getName())).orElse("unknown"));


        System.out.println("=======filter()与测试======");
//        filter() 接受一个 Predicate 参数，返回测试结果为 true 的值。如果测试结果为 false，会返回一个空的 Optional。
        System.out.println(Optional.ofNullable(user)
                .filter(u -> u.getName().equals("chunfeng123"))
                .isPresent());
        Optional.ofNullable(user).ifPresent(u -> System.out.println(u.getName()));

        

    }

    public static String getName(User user){
        /**
         * orElse()，它的工作方式非常直接，如果有值则返回该值，否则返回传递给它的参数值：
         */

        return Optional.ofNullable(user).map(u -> u.getName()).orElse("unknown");
    }

}
