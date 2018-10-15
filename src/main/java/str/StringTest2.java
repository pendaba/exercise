package main.java.str;

public class StringTest2 {
    public static void main(String[] args) {
        String str = new StringBuilder("ja").append("va").toString();
        System.out.println(str.intern() == str);

        String str2 = "计算机软件";
        String str1 = new String("计算机软件");
        System.out.println(str1.intern() == str2);


    }
}
