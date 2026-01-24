package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-01-24 1877
 */
public class MinimizeMaximumPairSum_1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int maxSum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            maxSum = Math.max(maxSum, nums[i] + nums[nums.length - 1 - i]);
        }

        return maxSum;

    }


    public static void main(String[] args) {
        int[] nums = {3,5,2,3};
        MinimizeMaximumPairSum_1877 sol = new MinimizeMaximumPairSum_1877();
        System.out.println(sol.minPairSum(nums));
    }
}
