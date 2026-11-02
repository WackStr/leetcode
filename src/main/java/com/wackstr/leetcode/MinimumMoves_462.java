package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-11-02 462
 */
public class MinimumMoves_462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        long moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return (int) moves;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,8,6};
        MinimumMoves_462 sol = new MinimumMoves_462();
        System.out.println(sol.minMoves2(nums));
    }
}
