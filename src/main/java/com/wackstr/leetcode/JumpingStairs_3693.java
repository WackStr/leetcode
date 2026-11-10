package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-11-10 3693
 */
public class JumpingStairs_3693 {

    public int climbStairs(int n, int[] costs){
        int[] dp = new int[costs.length+1];
        dp[dp.length - 1] = 0;
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] = costs[i] + dp[i+1] + 1;
            if(i < dp.length - 2) {
                dp[i] = Math.min(dp[i], costs[i + 1] + dp[i + 2] + 4);
            }
            if(i < dp.length - 3) {
                dp[i] = Math.min(dp[i], costs[i + 2] + dp[i + 3] + 9);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int n = 4;
        int[] costs = {1,2,3,4};
        JumpingStairs_3693 sol = new JumpingStairs_3693();
        System.out.println(sol.climbStairs(n, costs));
    }
}
