package com.wackstr.leetcode;

import java.util.Arrays;

public class HouseRobber_198 {
    public int rob(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxValue(nums, nums.length - 1, dp);
    }

    private int maxValue(int[] nums, int i, int[] dp) {
        if(i == 0) return nums[0];
        if(i < 0) return 0;
        if(dp[i] != -1) return dp[i];
        int val =  Math.max(
                maxValue(nums, i - 1, dp),
                maxValue(nums, i - 2, dp) + nums[i]);
        dp[i] = val;
        return val;
    }

    public static void main(String[] args) {
        int[] nums = {2, 11, 12};
        HouseRobber_198 sol = new HouseRobber_198();
        System.out.println(sol.rob(nums));
    }
}
