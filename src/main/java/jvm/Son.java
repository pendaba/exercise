package main.java.jvm;

public  class Son extends Parent implements ParentInterface{
    public static  final int a = 4;

    public Son(int a) {
        super(a);
    }

    public static void main(String[] args) {
        System.out.println(Son.a);
    }
}
