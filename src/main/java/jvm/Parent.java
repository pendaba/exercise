package main.java.jvm;

public class Parent {
    public static final int a = 3;


    public static  int b = 4;
    {
        System.out.println("aaaa");
    }
    static {
        b = 5;
        System.out.println("b="+b);
    }

    public Parent(int a){
        System.out.println("a="+a);
    }

    public static void main(String[] args) {
       Parent parent =  new Parent(2);
        System.out.println("bbbb");
    }
}
