package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-08-03 1406
 */
public class StoneGameIII_1406 {

    private static final String ALICE = "Alice";
    private static final String BOB = "Bob";
    private static final String TIE = "Tie";

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n];
        String res = TIE;
        int[] dp = new int[n];
        int aliceScore;

        Arrays.fill(dp, -1);

        prefix[n-1] = stoneValue[n-1];
        for (int i = n-2; i >= 0; i--) prefix[i] = prefix[i+1]+stoneValue[i];

        aliceScore = score(0, prefix, dp);
        aliceScore += aliceScore;

        if(aliceScore > prefix[0]) res = ALICE;
        else if(aliceScore < prefix[0]) res = BOB;

        return res;
    }

    private int score(int i, int[] prefix, int[] dp) {
        if(i >= prefix.length) return 0;
        if(dp[i] == -1){
            int sum = prefix[i];
            if(i == prefix.length - 1) dp[i] = sum;
            else {
                int res = sum - score(i + 1, prefix, dp);
                res = Math.max(res, sum - score(i + 2, prefix, dp));
                res = Math.max(res, sum - score(i + 3, prefix, dp));
                dp[i] = res;
            }
        }
        return dp[i];
    }

    public static void main(String[] args) {
        int[] stoneValue = {1, 2, 3, 6};
        StoneGameIII_1406 sol = new StoneGameIII_1406();
        System.out.println(sol.stoneGameIII(stoneValue));
    }
}
