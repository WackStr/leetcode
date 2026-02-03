package com.wackstr.leetcode;

/*
2026-02-03 3637
 */
public class TrionicArray_3637 {
    public boolean isTrionic(int[] nums) {
        int cnt = 0; // to track length of last phase
        int i = 1; // running index

        // increasing phase
        while(i < nums.length && nums[i] > nums[i-1]) {
            i++;
            cnt++;
        }
        // should capture a non-zero phase
        if(cnt == 0) return false;

        // decreasing phase
        cnt = 0;
        while (i < nums.length && nums[i] < nums[i - 1]) {
            i++;
            cnt++;
        }
        // should capture a non-zero phase plus have room for last phase
        if(cnt == 0 || i == nums.length) return false;

        while (i < nums.length){
            if(nums[i] <= nums[i - 1]) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,3};
        TrionicArray_3637 sol = new TrionicArray_3637();
        System.out.println(sol.isTrionic(nums));
    }
}
