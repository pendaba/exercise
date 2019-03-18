package main.java.data.solution;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {

    public static int[] arr = new int[new Random().nextInt(100)];

    static {
        for(int i = 0;i< arr.length;i++){
            arr[i] = new Random().nextInt(100);
        }
    }





    public static void main(String[] args) {
        int[] arr1 = {1,5,3,4,2,3,4,6};
        aa(arr1);

    }
    public static void aa(int[] arr){

        Arrays.stream(arr).distinct().sorted().forEach(System.out::println);
    }
}
