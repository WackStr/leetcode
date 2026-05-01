package com.wackstr.leetcode;

/*
2026-05-01 396
 */
public class RotateFunction_396 {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int f = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
            f += i*nums[i];
        }
        int max = f;
        for(int i=n-1;i>0;i--){
            f = f+sum-(n*nums[i]);
            max = Math.max(max,f);
        }
        return max;
    }
}
