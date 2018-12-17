package main.java.sort;

import java.util.Arrays;

/**
 * @author fupengga
 *
 * 在许多算法中有些条件在算法执行时总是不变的：
 * 冒泡排序时外层循环右边的数据项总是有序的+
 *
 *
 *冒泡排序比较次数和交换次数都是n^2级别的
 * 冒泡排序的不变性外层循环右边的数据项总是有序的
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] arr){
        int temp;
//      控制比较次数
        for(int j = arr.length-1;j>1;j--){
//          冒泡
            for(int i = 0;i<j;i++){
                if(arr[i]>arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,7,78,123,34,12};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}
