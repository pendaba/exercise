package main.java.algorithm;

public class Median {
    /**
     * 找出两个有序数组的中位数
     * @param nums1
     * @param nums2
     * @return
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        int m = nums1.length;
//        int n = nums2.length;
//        int k = (m+n)/2;
//        if((m+n)%2 == 1 ){
//            return findKth(nums1,0,m-1,nums2,0,n-1,k+1);
//        }else{
//            return (findKth(nums1,0,m-1,nums2,0,n-1,k)+findKth(nums1,0,m-1,nums2,0,n-1,k+1))/2.0;
//        }
//    }
//
//    private double findKth(int[] nums1, int i, int i1, int[] nums2, int i2, int i3, int k) {
//        int m = i1-i+1;
//        int n = i3-i2+1;
//        if(m > n){
//            return findKth(nums2,i3,i2,nums1,i,i1,k);
//        }
//        if( m == 0){
//            return nums2[i3+k-1];
//        }
//        if(k ==1 ){
//            return Math.min(nums1[i],nums2[i3]);
//        }
//    }

}
