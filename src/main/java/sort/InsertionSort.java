package main.java.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fupengga
 * 插入排序
 * <p>
 * 每趟排序结束时外层循环左边的数据项都是有序的
 */
public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        int temp;

//        外层循环起始位置为i=1;i左边的数据项已经有序
//        for(int i = 1;i<arr.length;i++){
////          将i位置的数据插入左边的有序队列
//            for(int j = i;j>0;j--){
//                if(arr[j]<arr[j-1]){
//                     temp = arr[j];
//                     arr[j]= arr[j-1];
//                     arr[j-1]= temp;
//                }else{
//                    break;
//                }
//            }
//        }
//        int preIndex,current;
//        for(int i = 1;i<arr.length;i++){
//            preIndex = i-1;
//            current = arr[i];
//            while (preIndex>=0 && arr[preIndex] > current){
//                arr[preIndex+1] = arr[preIndex];
//                preIndex--;
//            }
//            arr[preIndex+1] = current;
//        }



        int preIndex, current;
        for (int i = 1; i < arr.length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;


        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 7, 78, 123, 34, 12, 3};

        System.out.println(Arrays.toString(insertionSort(arr)));
    }
}
