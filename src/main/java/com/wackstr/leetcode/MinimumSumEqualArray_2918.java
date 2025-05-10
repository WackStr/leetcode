package com.wackstr.leetcode;

/*
2025-05-10
 */
public class MinimumSumEqualArray_2918 {
    public long minSum(int[] nums1, int[] nums2){
        int zeroes1 = 0, zeroes2 = 0;
        long sum1 = 0, sum2 = 0;
        for(int num : nums1){
            if(num == 0) zeroes1++;
            else sum1 += num;
        }
        for(int num : nums2){
            if(num == 0) zeroes2++;
            else sum2 += num;
        }

        if(zeroes1 == 0 && zeroes2 == 0){
            return sum1 == sum2 ? sum1 : -1L;
        }
        else if(zeroes1 == 0) {
            sum2 += zeroes2;
            return sum1 >= sum2 ? sum1 : -1L;
        }else if (zeroes2 == 0){
            sum1 += zeroes1;
            return sum2 >= sum1 ? sum2 : -1L;
        }else{
            sum1 += zeroes1;
            sum2 += zeroes2;
            return Math.max(sum1, sum2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2, 0}, nums2 = {1,4};
        MinimumSumEqualArray_2918 sol = new MinimumSumEqualArray_2918();
        System.out.println(sol.minSum(nums1, nums2));
    }
}
