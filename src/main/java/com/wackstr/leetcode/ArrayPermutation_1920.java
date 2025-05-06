package com.wackstr.leetcode;

public class ArrayPermutation_1920 {
    public int[] buildArray(int[] nums){
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
