package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-11-19 2567
 */
public class MinimumScore_2567 {

    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if (n == 3) return 0;
        Arrays.sort(nums);
        int res = nums[n - 3] - nums[0];
        res = Math.min(res, nums[n-1] - nums[2]);
        return Math.min(res, nums[n-2] - nums[1]);
    }

    public static void main(String[] args) {
        int[] nums = {58,42,8,75,28};
        MinimumScore_2567 sol = new MinimumScore_2567();
        System.out.println(sol.minimizeSum(nums));
    }
}
