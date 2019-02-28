package main.java.sort;

import java.util.Arrays;

/**
 * @author fupengga
 * 希尔排序
 * 思想：通过增量排序和插入排序结合的方式，提高排序的效率。
 * 增量的间隔序列表达式：h=3h+1
 * 希尔排序比插入排序快的原因：1 增量排序数据移动少且有效率；2 增量排序之后的数据基本有序，插入排序的复制也会减少。
 *
 */
public class ShellSort {
    /**
     * while实现
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr){
        int temp;
        //增量排序的增量，一般用h表示
        int h = 1;
        while (h <= arr.length/3){
            h = h*3 + 1;
        }
        while (h > 0){
            for(int outer = h;outer<arr.length;outer++){
                temp = arr[outer];
                int inner = outer;
                System.out.println("外层循环  h:"+h+"  ,temp:"+temp+"    ,inner:"+inner+"    ,arr:"+Arrays.toString(arr));
                while(inner > h-1 && arr[inner-h] >= temp){
                    arr[inner] = arr[inner-h];
                    inner -= h;
                }
                arr[inner] = temp;
            }
            h = (h-1)/3;
        }


        return arr;

    }

    /**
     * for循环实现
     * @param arr
     * @return
     */
    public static int[] shellSort1(int[] arr) {
        int temp;
        //增量排序的增量，一般用h表示
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int outer = h; outer < arr.length; outer++) {
                System.out.println("外层循环  h="+h+"    ,outer="+outer+"    ,       arr:"+Arrays.toString(arr));
                for (int j = outer; j > h-1; j -= h) {
                    System.out.println("=======内层循环  outer="+outer+"    ,j="+j+"    ,arr:"+Arrays.toString(arr));
                    if (arr[j] < arr[j - h]) {
                        temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                    } else {
                        break;
                    }
                }
            }
            h = (h - 1) / 3;
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {1,10,7,78,123,34,12,68,90,345,89};
        System.out.println(Arrays.toString(shellSort1(arr)));

    }
}
