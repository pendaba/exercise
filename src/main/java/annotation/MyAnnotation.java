package main.java.annotation;

import java.lang.annotation.*;

/**
 * @author fupengga
 * 使用@interface自定义注解，自动继承了java.lang.annotation.Annotation接口，由编译程序自动完成其他细节。
 * 在定义注解时，不能继承其他的注解或接口。@interface用来声明一个注解，其中的每一个方法实际上是声明了一个配置参数。
 * 方法的名称就是参数的名称，返回值类型就是参数的类型（返回值类型只能是基本类型、Class、String、enum）。可以通过default来声明参数的默认值。
 *
 * 注解的应用：生成文档，编译期检查，灵活配置
 *
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation {
     String value() default "";
     String name() default "tom";
     int age() default 18;
     enum Color{GREE,RED,BLUE}
     Color favoriteColor() default Color.BLUE;


}
