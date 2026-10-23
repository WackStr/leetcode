package com.wackstr.leetcode;

/*
2026-10-23 3644
 */
public class KSort_3644 {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == i) {
                continue;
            }
            res &= nums[i];
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
