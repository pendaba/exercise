package main.java.data.search;

/**
 * @author fupengga
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {1, 4,9,12,19,23,34,45,56};
        System.out.println(binarySearch(numbers,34));
        System.out.println(recursionSearch(34,0,numbers.length,numbers));
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
    public static int recursionSearch(int target,int low,int high,int[] nums){
        int currentIndex = (low+high)/2;
        if(nums[currentIndex] == target){
            return currentIndex;
        }else if(low > high){
            return -1;
        }else{
            if(nums[currentIndex]<target){
                return recursionSearch(target,currentIndex+1,high,nums);
            }else{
                return recursionSearch(target,low,currentIndex-1,nums);
            }
        }
    }
}
