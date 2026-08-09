package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-08-09 1140
 */
public class StoneGameII_1140 {
    public int stoneGameII(int[] piles){
        int n = piles.length;
        int[][] dp = new int[n][64];
        int[] prefixSum = new int[n];

        for (int[] row : dp) Arrays.fill(row, -1);
        prefixSum[n-1] = piles[n-1];
        for (int i = n-2; i >= 0; i--) prefixSum[i] = piles[i] + prefixSum[i+1];
        return pick(0, 1, prefixSum, dp);
    }

    private int pick(int i, int m, int[] prefixSum, int[][] dp) {
        if(i >= prefixSum.length) return 0;
        if(i == prefixSum.length - 1) return prefixSum[prefixSum.length - 1];
        if(dp[i][m] == -1) {
            int score = -1;
            for (int take = 1; take <= Math.min(prefixSum.length - i, 2 * m); take++) {
                score = Math.max(score, prefixSum[i] - pick(
                        i + take,
                        Math.max(take, m),
                        prefixSum,
                        dp));
            }
            dp[i][m] = score;
        }
        return dp[i][m];
    }

    public static void main(String[] args) {
        int[] piles = {2, 7, 9, 4, 4};
        StoneGameII_1140 sol = new StoneGameII_1140();
        System.out.println(sol.stoneGameII(piles));
    }
}
