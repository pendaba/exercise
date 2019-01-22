package main.java.reflect;

import java.lang.reflect.Constructor;

/**
 * @author fupengga
 * Reflection enables Java code to discover information about the fields, methods and constructors of loaded classes,
 * and to use reflected fields, methods, and constructors to operate on their underlying counterparts, within security restrictions.
 * Java 反射主要提供以下功能：
 *  在运行时判断任意一个对象所属的类；
 *  在运行时构造任意一个类的对象；
 *  在运行时判断任意一个类所具有的成员变量和方法（通过反射甚至可以调用private方法）；
 *  在运行时调用任意一个对象的方法
 *
 *
 *  获取Class的三种方法：1 Class.forName 2 对象.class 3 实例.getClass()
 *
 *
 * 一般地，我们用 instanceof 关键字来判断是否为某个类的实例。同时我们也可以借助反射中 Class 对象的 isInstance() 方法来判断是否为某个类的实例，它是一个 native 方法：
 *


 */
public class ReflectTest {

    public static void main(String[] args) throws Exception{
        //获取Class 1 Class.forName 2 对象.class 3 实例.getClass()
        Student student = new Student();

        Class<Student> studentClass1 = (Class<Student>) student.getClass();
        Class<Student> studentClass2 = Student.class;

        System.out.println(Student.class == student.getClass());
        System.out.println(studentClass2.getName());
        Class<Student> studentClass3 = (Class<Student>) Class.forName(studentClass2.getName());
        System.out.println(studentClass3 == studentClass1);


        //通过反射来生成实例
        Student student1 = studentClass1.newInstance();

        //获取String所对应的Class对象
        Class<?> c = String.class;
        //获取String类带一个String参数的构造器
        Constructor constructor = c.getConstructor(String.class);
        //根据构造器创建实例
        Object obj = constructor.newInstance("23333");
        System.out.println(obj);


    }

}
