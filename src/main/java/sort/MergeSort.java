package main.java.sort;

import java.util.Arrays;

/**
 * @author fupengga
 * 归并排序
 * 思想：归并两个已经有序的数组，时间复杂度：N*logN
 */
public class MergeSort {
    //复制次数
    private static int count = 0;
    //比较次数
    private static int number = 0;

    private static String aa = "-";

    public static void recursionMergerSort(int[] arr,int low,int high,int[] temp){
        if(low == high){
            return;
        }else{
            int middle = (low + high)/2;
            recursionMergerSort(arr,low,middle,temp);
            recursionMergerSort(arr,middle+1,high,temp);
            merge(arr,low,middle,high,temp);
        }
    }
    public static void mergerSort(int[] arr){
        int[] temp = new int[arr.length];
        recursionMergerSort(arr,0,arr.length-1,temp);

    }
    private static void merge(int[] arr,int low,int middle,int high,int[] temp){
        //左序列指针
        int i = low;
        //右序列指针
        int j = middle+1;
        //临时序列指针
        int t = 0;
        System.out.println("归并前数组：" +Arrays.toString(arr));
        while(i<=middle && j<= high){
            if(arr[i] < arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }

        while (i<=middle){
            temp[t++] = arr[i++];
        }

        while (j<=high){
            temp[t++] = arr[j++];
        }

        //将排序好的元素复制进数组
        t=0;
        while(low <= high){
            arr[low++] = temp[t++];
        }
        System.out.println("归并后数组：" +Arrays.toString(arr)+"   ,归并次数："+ ++count);
        System.out.println("==================================================================================================================");
    }
    public static void main(String[] args) {
        int[] arr = {1, 10, 7, 78, 123, 34, 12, 3};
        mergerSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
