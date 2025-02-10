package com.wackstr.leetcode;

/*
2025-02-04
 */
public class MaximumAscendingSubarraySum_1800 {
    public int maxAscendingSum(int[] nums){
        int maxSum = nums[0];
        int currSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                currSum += nums[i];
            }else{
                maxSum = Math.max(maxSum, currSum);
                currSum = nums[i];
            }
        }
        maxSum = Math.max(maxSum, currSum);
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 5, 10, 50};
        MaximumAscendingSubarraySum_1800 sol =
                new MaximumAscendingSubarraySum_1800();
        System.out.println(sol.maxAscendingSum(nums));
    }
}
