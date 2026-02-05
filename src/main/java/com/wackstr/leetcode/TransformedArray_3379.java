package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-02-05 3379
 */
public class TransformedArray_3379 {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = nums[((i + nums[i]) % n + n) % n];
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, -2, 1, 1};
        TransformedArray_3379 sol = new TransformedArray_3379();
        System.out.println(Arrays.toString(sol.constructTransformedArray(nums)));
    }
}
