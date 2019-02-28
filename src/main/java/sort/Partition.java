package main.java.sort;


import java.util.Arrays;

/**
 * @author fupengga
 * 划分
 * 思想：把数据分为两组，使所有关键字大于特定值的数组项在一组，使所有关键字小于特定值的数据项在另一组.这个特定值一般被称为枢纽或者支点
 */
public class Partition {
    public static int partition(int[] arr,int left,int right,int pivot){
        int temp;
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true){
            while(leftPtr < right && arr[++leftPtr] < pivot){}
            while(rightPtr > left && arr[--rightPtr] > pivot){}
            if(leftPtr >= rightPtr){
                break;
            }else{
                temp = arr[leftPtr];
                arr[leftPtr] = arr[rightPtr];
                arr[rightPtr] = temp;
            }
        }
        return leftPtr;

    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 7, 78, 123, 34, 12, 3};
        int left = partition(arr,0,arr.length-1,13);
        System.out.println(Arrays.toString(arr)+"            ,left="+left);
    }
}
