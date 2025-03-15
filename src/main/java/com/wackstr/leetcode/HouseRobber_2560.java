package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-03-15
 */
public class HouseRobber_2560 {
    public int minCapability(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int withFirst = capability(nums, nums[0], 1, k, 1, dp);
        if(canNotTake(nums.length, k, 0, 0)){
            int withoutFirst = capability(nums, 0, 1, k, 0, dp);
            return Math.min(withFirst, withoutFirst);
        }else {
            return withFirst;
        }
    }

    private boolean canNotTake(int n, int k, int i, int acc) {
        return acc + (n-i) / 2 >= k;
    }

    private int capability(int[] nums, int max, int i, int k, int total, int[] dp) {
        if(i > nums.length) return total >= k ? max : 0;

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5,9};
        int k = 2;
        HouseRobber_2560 sol = new HouseRobber_2560();
        sol.minCapability(nums, k);
    }
}
