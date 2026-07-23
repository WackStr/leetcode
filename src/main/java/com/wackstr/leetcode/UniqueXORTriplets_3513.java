package com.wackstr.leetcode;

/*
2026-07-23 3513
 */
public class UniqueXORTriplets_3513 {
    public int uniqueXorTriplets(int[] nums) {
        if(nums.length <=2 ) return nums.length;
        return Integer.highestOneBit(nums.length) * 2;
    }
}
