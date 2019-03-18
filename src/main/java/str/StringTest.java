package main.java.str;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String a = "aaaaaaaa";
//        changeStr(a);
//        System.out.println(a);
        System.out.println(Arrays.toString(a.getBytes()));
        int[] arr = {1,3,4,5,6,7,3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static String changeStr(String str){
        str = "hello world";
        return str;
    }


}