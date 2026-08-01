package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-08-01
 */
public class PredictWinner_486 {

    public boolean predictTheWinner(int[] nums){
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int x = score(0, n-1, prefix, dp);
        return (x+x) >= prefix[n-1];
    }

    private int score(int l, int r, int[] prefix, int[][] dp) {
        if(dp[l][r] == -1) {
            int sum = prefix[r] - (l > 0 ? prefix[l-1] : 0);
            if(l == r) dp[l][r] = sum;
            else {
                int a = sum - score(l + 1, r, prefix, dp);
                int b = sum - score(l, r - 1, prefix, dp);
                dp[l][r] = Math.max(a, b);
            }
        }
        return dp[l][r];
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1};
        PredictWinner_486 sol = new PredictWinner_486();
        System.out.println(sol.predictTheWinner(nums));
    }
}
