package com.wackstr.leetcode;

/*
2026-05-23 1752
 */
public class CheckSortedRotatedArray_1752 {
    public boolean check(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int i = 1;
        while(i < n && nums[i] >= nums[i-1]) i++;
        if(i < n) {
            if (nums[i] > min) return false;
            i++;
            while (i < n) {
                if (nums[i] < nums[i - 1] || nums[i] > min) return false;
                i++;
            }
        }
        return true;
    }
}
