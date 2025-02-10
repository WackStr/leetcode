package com.wackstr.leetcode;

/*
2025-02-02
 */
public class ArrayCheck_1752 {
    public boolean check(int[] nums){
        if(nums.length == 1) return true;
        int n = nums.length;
        int falls = 0;
        if(nums[0] < nums[n - 1]) falls++;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]) falls++;
            if(falls > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ArrayCheck_1752 sol = new ArrayCheck_1752();
        System.out.println(sol.check(nums));
    }
}
