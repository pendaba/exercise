package main.java.sort;

import java.util.Arrays;

public class InsertionSort {
    public static int[] insertionSort(int[] arr){
        int temp;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }else{
                    //不需要交换.
                    break;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {1,10,7,78,123,34,12};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }
}
