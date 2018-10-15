package main.java.str;

public class StringTest {
    public static void main(String[] args) {
        String a = "aaaaaaaa";
        changeStr(a);
        System.out.println(a);
    }
    private static String changeStr(String str){
        str = "hello world";
        return str;
    }

}
