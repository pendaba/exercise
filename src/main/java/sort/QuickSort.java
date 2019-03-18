package main.java.sort;

import java.util.Arrays;

/**
 * @author fupengga
 * 快速排序
 * 思想：
 * 时间复杂度:O(N*logN)
 */
public class QuickSort {
    static String deep = "-";

    public static void quickSort(int[] arr){
        recursionQuickSort(arr,0,arr.length-1);
    }

    /**
     * 总是选择数组最有边的数据项作为枢纽。
     * 缺点：会导致数组逆序的情况下快速排序的复杂度降为O(N^2)级别，这是因为总是将数组分为一个和length-1个子数组。这样也会增加递归的深度，增加了栈溢出的可能。
     * @param arr
     * @param left
     * @param right
     */
    public static void recursionQuickSort(int[] arr,int left,int right){
        if(right - left <= 0){
            return;
        }else{
            int pivot = arr[right];
            int partition = partition(arr, left,right,pivot);
            recursionQuickSort(arr, left,partition-1);
            recursionQuickSort(arr,partition+1,right);
            deep=deep+"-";
            System.out.println(deep+"--"+Arrays.toString(arr)+"     ,partition="+partition+"     ,pivot="+pivot);
        }
    }

    /**
     * 三数据项取中的快速排序，总是选择数组左右边界和中间的三个数据项中的中值，避免了逆序情况下快速排序时间复杂度降为(N^2)的缺陷。同时也对这三个数据项进行排序
     * @param arr
     * @param left
     * @param right
     */
    public static void recursionQuickSortOfMedian(int[] arr,int left,int right){
        int size = right- left +1;
        if(size <= 3){
            manualSort(arr, left,right);
        }else{
            int median = medianOf3(arr, left,right);
            int partition = partition1(arr,left,right,median);
            recursionQuickSortOfMedian(arr, left,partition-1);
            recursionQuickSortOfMedian(arr,partition+1,right);
        }
    }

    private static int partition1(int[] arr,int left, int right, int pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;
        while (true){
            while (arr[++leftPtr] < pivot){}
            while (arr[--rightPtr] > pivot){}
            if(leftPtr >= rightPtr){
                break;
            }else{
                swap(arr,leftPtr,rightPtr);
            }
        }
        swap(arr,leftPtr,right-1);
        return leftPtr;
    }
    private static void manualSort(int[] arr, int left, int right){
        int size = right-left+1;
        if(size <= 1){
            return;
        }
        if(size == 2){
            if(arr[left] > arr[right]){
                swap(arr,left,right);
            }
        }else{
            if(arr[left] > arr[right-1]){
                swap(arr, left,right-1);
            }
            if(arr[left]> arr[right]){
                swap(arr,left,right);
            }
            if(arr[right-1]> arr[right]){
                swap(arr,right-1,right);
            }
        }

    }

    private static int medianOf3(int[] arr,int left, int right) {
        int center = (left +right)/2;
        if(arr[left] > arr[center]){
            swap(arr, left,center);
        }
        if(arr[left]> arr[right]){
            swap(arr,left,right);
        }
        if(arr[center]> arr[right]){
            swap(arr,center,right);
        }
        //把枢纽放在数组右边边界
        swap(arr,center,right-1);
        return arr[right-1];
    }
    public static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public static int partition(int[] arr,int left,int right,int pivot){
        int temp;
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true){
            while(arr[++leftPtr] < pivot){}
            while(rightPtr > 0 && arr[--rightPtr] > pivot){}
            if(leftPtr >= rightPtr){
                break;
            }else{
                temp = arr[leftPtr];
                arr[leftPtr] = arr[rightPtr];
                arr[rightPtr] = temp;
            }
        }
        temp = arr[leftPtr];
        arr[leftPtr] = arr[right];
        arr[right] = temp;
        return leftPtr;

    }


    public static void main(String[] args) {
        int[] arr = {90,100,20,60,80,110,120,40,10,30,50,70};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
