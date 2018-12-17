package main.java.sort;


import java.util.Arrays;

/**
 * @author fupengga
 * 选择排序
 * 不变性：选择排序下标小于等于外层循环位置的数据项总是有序的
 */
public class SelectionSort {
    public static int[] selectionSort(int[] arr){

        int temp;
//        外层循环控制每次重新比较的起始位置；控制循环的次数
        for(int i = 0;i<arr.length-1;i++){
            int minIndex = i ;
            //1：内层控制比较次数，选出最小值的下标；
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }

            if(minIndex != i){
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }






        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {20,3,64,23,123,34,12,1};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }
}
