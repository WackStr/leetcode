package com.wackstr.leetcode;

/*
2025-11-29 3512
 */
public class MinimumOperations_3512 {
    public int minOperations(int[] nums, int k){
        int res = 0;
        for (int num : nums) res = (res + num) % k;
        return res;
    }
}
