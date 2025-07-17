package com.wackstr.leetcode;

/*
2025-07-15
 */
public class ValidSubsequence_3202 {

    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                res = Math.max(res, dp[prev][num]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,2,3,1,4};
        int k = 3;
        ValidSubsequence_3202 sol = new ValidSubsequence_3202();
        System.out.println(sol.maximumLength(nums, k));
    }
}
