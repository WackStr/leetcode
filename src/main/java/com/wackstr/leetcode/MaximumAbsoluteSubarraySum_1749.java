package com.wackstr.leetcode;

/*
2025-02-26
 */
public class MaximumAbsoluteSubarraySum_1749 {

    public int maxAbsoluteSum(int[] nums){
        int n = nums.length;
        int maxSum = nums[0];
        int minSum = nums[0];
        int maxEnding = nums[0];
        int minEnding = nums[0];
        for(int i = 1; i < n; i++){
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            minEnding = Math.min(minEnding + nums[i], nums[i]);
            maxSum = Math.max(maxSum, maxEnding);
            minSum = Math.min(minSum, minEnding);
        }
        return Math.max(Math.abs(minSum), Math.abs(maxSum));
    }

    public static void main(String[] args) {
        int[] nums = {1, -3, 2, 3, -4};
        MaximumAbsoluteSubarraySum_1749 sol =
                new MaximumAbsoluteSubarraySum_1749();
        System.out.println(sol.maxAbsoluteSum(nums));
    }
}
