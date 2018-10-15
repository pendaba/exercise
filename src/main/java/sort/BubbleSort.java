package main.java.sort;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] arr){
        int temp;
//        for(int i=0; i<arr.length-1; i++){   //表示趟数，一共arr.length-1次。
//            for(int j=arr.length-1; j>i; j--){
//                if(arr[j] < arr[j-1]){
//                    temp = arr[j];
//                    arr[j] = arr[j-1];
//                    arr[j-1] = temp;
//                }
//            }
//        }
       /*for(int i=0;i<arr.length;i++){
           for(int j=1;j<arr.length-i;j++){
               if(arr[j-1]>arr[j]){
                   temp = arr[j];
                   arr[j] = arr[j-1];
                   arr[j-1] = temp;
               }
           }
       }
*/

//        int temp;//临时变量
//        boolean flag;//是否交换的标志
//        for(int i=0; i<arr.length-1; i++){   //表示趟数，一共arr.length-1次。
//            flag = false;
//            for(int j=arr.length-1; j>i; j--){
//                if(arr[j] < arr[j-1]){
//                    temp = arr[j];
//                    arr[j] = arr[j-1];
//                    arr[j-1] = temp;
//                    flag = true;
//                }
//            }
//            if(!flag) break;
//        }
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length-1;j++){
                if(arr[j]<arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
//        int[] arr = {1,3,7,78,123,34,12};
//        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println("".length());
    }
}
