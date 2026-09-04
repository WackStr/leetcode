package com.wackstr.leetcode;

/*
2026-09-04 3903
 */
public class SmallestStableIndex_3903 {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            prefix[i] = Math.min(nums[i], prefix[i+1]);
        }
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if(max - prefix[i] <= k) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 0, 1, 4};
        int k = 3;
        SmallestStableIndex_3903 sol = new SmallestStableIndex_3903();
        System.out.println(sol.firstStableIndex(nums, k));
    }
}
