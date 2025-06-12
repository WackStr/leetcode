package com.wackstr.leetcode;

/*
2025-06-12
 */
public class ArrayDifference_3423 {
    public int maxAdjacentDistance(int[] nums) {
        int res = Math.abs(nums[0] - nums[nums.length - 1]);
        for(int i = 1; i < nums.length; i++){
            res = Math.max(res, Math.abs(nums[i] - nums[i-1]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-5, -10, -5};
        ArrayDifference_3423 sol = new ArrayDifference_3423();
        System.out.println(sol.maxAdjacentDistance(nums));
    }
}
