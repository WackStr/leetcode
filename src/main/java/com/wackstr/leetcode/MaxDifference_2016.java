package com.wackstr.leetcode;

/*
2025-06-16
 */
public class MaxDifference_2016 {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1, premin = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > premin) {
                ans = Math.max(ans, nums[i] - premin);
            } else {
                premin = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 10};
        MaxDifference_2016 sol = new MaxDifference_2016();
        System.out.println(sol.maximumDifference(nums));
    }


}
