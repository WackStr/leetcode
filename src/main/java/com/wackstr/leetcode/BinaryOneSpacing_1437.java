package com.wackstr.leetcode;

/*
2025-11-17
 */
public class BinaryOneSpacing_1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int left = 0;
        while(left < nums.length && nums[left] == 0) left++;
        for (int i = left + 1; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(i - left - 1 < k) return false;
                else left = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,1};
        int k = 1;
        BinaryOneSpacing_1437 sol = new BinaryOneSpacing_1437();
        System.out.println(sol.kLengthApart(nums, k));
    }
}
