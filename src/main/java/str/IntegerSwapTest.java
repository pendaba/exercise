package main.java.str;

import java.lang.reflect.Field;

public class IntegerSwapTest {
    public static void swap(Integer num1,Integer num2) throws  Exception{
       Field field =  Integer.class.getDeclaredField("value");
       field.setAccessible(true);
       int temp = num1.intValue();
       field.set(num1,num2);
       field.set(num2,new Integer(temp));
    }

    public static void main(String[] args) throws  Exception{
        Integer a = 1;
        Integer b = 2;
//        int c =1 ;
        System.out.println(a +"    ,    "+b );
        swap(a,b);
        System.out.println(a +"    ,    "+b );
        System.out.println( Integer.class.getClassLoader());

    }
}
