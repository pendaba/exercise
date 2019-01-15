package main.java.data.search;

/**
 * @author fupengga
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {1, 4,9,12,19,23,34,45,56};
        System.out.println(binarySearch(numbers,34));
    }

    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int middle = 0;
        int high = nums.length-1;
        if(low>high || nums[low]>target || nums[high] < target){
            return  -1;
        }
        while (low <= high){
            middle = (low+high)/2;
            if(nums[middle] == target){
                return middle;
            } else if(nums[middle]> target){
                high = middle -1;
            } else if(nums[middle] < target){
                low = middle + 1;
            }
        }
        return -1;
    }
}
