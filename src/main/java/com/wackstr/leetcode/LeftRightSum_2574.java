package com.wackstr.leetcode;

/*
2026-06-06 2574
 */
public class LeftRightSum_2574 {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int leftSum = 0;
        for (int num : nums) {
            leftSum += num;
        }
        int rightSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            leftSum -= nums[i];
            res[i] = Math.abs(leftSum - rightSum);
            rightSum += nums[i];
        }
        return res;
    }
}
