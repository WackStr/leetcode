package com.wackstr.leetcode;

/*
2026-09-24 3550
 */
public class IndexSum_3550 {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int digitSum = 0;
            int digit = nums[i];
            while(digit > 0){
                digitSum += digit % 10;
                digit /= 10;
            }
            if(digitSum == i) return i;
        }
        return -1;

    }
}
