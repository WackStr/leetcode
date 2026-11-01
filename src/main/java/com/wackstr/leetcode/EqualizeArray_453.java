package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-11-01 453
 */
public class EqualizeArray_453 {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        // Find the minimum element in the array
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        // Sum the differences between each element and the minimum
        int moves = 0;
        for (int num : nums) {
            moves += num - min;
        }

        return moves;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        EqualizeArray_453 sol = new EqualizeArray_453();
        System.out.println(sol.minMoves(nums));
    }
}
