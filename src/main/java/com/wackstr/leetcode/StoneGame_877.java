package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-08-02 877
 */
public class StoneGame_877 {
    public boolean stoneGame(int[] piles){
        /*
        Alice can take all even or odd piles as she chooses. one of the sums
        is larger, so she can force the win always.
         */
        return true;
    }

    private boolean dp(int[] piles) {
        int n = piles.length;
        int[] prefix = new int[n];
        prefix[0] = piles[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]+ piles[i];
        }
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int x = score(0, n-1, prefix, dp);
        return x > prefix[n - 1] / 2;
    }

    private int score(int l, int r, int[] prefix, int[][] dp) {
        if(dp[l][r] == -1){
            int sum = prefix[r] - (l > 0 ? prefix[l-1] : 0);
            if(l == r) dp[l][r] = sum;
            else{
                int a = sum - score(l+1, r, prefix, dp);
                int b = sum - score(l, r-1, prefix, dp);
                dp[l][r] = Math.max(a, b);
            }
        }
        return dp[l][r];
    }

    public static void main(String[] args) {
        int[] piles = {3, 7, 2, 3};
        StoneGame_877 sol = new StoneGame_877();
        System.out.println(sol.stoneGame(piles));
    }
}
