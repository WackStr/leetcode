package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

/*
2025-10-11
 */
public class SpellCasting_3186 {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);

        long[] dp = new long[power.length];
        long md = 0;
        dp[0] = power[0];
        long max = 0;
        for (int i = 1, j = 0; i < power.length; i++) {
            if (power[i] == power[i - 1]) dp[i] = dp[i - 1] + power[i];
            else {
                while (power[j] + 2 < power[i]) md = Math.max(md, dp[j++]);
                dp[i] = md + power[i];
            }
            max = Math.max(max, dp[i]);
        }
        return Math.max(max, dp[0]);
    }

    public static void main(String[] args) {
        int[] power = {1, 1, 3, 4};
        SpellCasting_3186 sol = new SpellCasting_3186();
        System.out.println(sol.maximumTotalDamage(power));
    }
}
