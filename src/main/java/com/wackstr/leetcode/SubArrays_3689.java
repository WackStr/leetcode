package com.wackstr.leetcode;

/*
2026-06-09 3689
 */
public class SubArrays_3689 {
    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = -1;
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (max - min) * (long) k;
    }
}
