package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-02-06 3634
 */
public class BalanceArray_3634 {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            while ((long) nums[j] > (long) nums[i] * k) {
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return nums.length - maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5};
        int k = 84298;
        BalanceArray_3634 sol = new BalanceArray_3634();
        System.out.println(sol.minRemoval(nums, k));
    }
}
