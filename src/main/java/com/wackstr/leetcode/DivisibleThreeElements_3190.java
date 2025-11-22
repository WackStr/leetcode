package com.wackstr.leetcode;

/*
2025-11-22
 */
public class DivisibleThreeElements_3190 {
    public int minimumOperations(int[] nums){
        int res = 0;
        for (int num : nums)
            res += num % 3 == 0 ? 0 : 1;
        return res;
    }
}
