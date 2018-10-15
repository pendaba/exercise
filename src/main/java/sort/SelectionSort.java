package main.java.sort;


import java.util.Arrays;

public class SelectionSort {
    public static int[] selctionSort(int[] arr){

        for(int i=0;i<arr.length;i++){
            int minIndex = i;
            for(int j=i+1;j< arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,7,78,123,34,12};
        System.out.println(Arrays.toString(selctionSort(arr)));
    }
}
