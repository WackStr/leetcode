package com.wackstr.leetcode;

import java.util.ArrayDeque;

/*
2025-09-09
 */
public class SecretAware_2327 {

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        long sum = 0;
        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1) {
                sum = (sum + dp[day - delay]) % MOD;
            }
            if (day - forget >= 1) {
                sum = (sum - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = (int) sum;
        }

        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) ans = (ans + dp[i]) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int n = 6, delay = 2, forget = 4;
        SecretAware_2327 sol = new SecretAware_2327();
        System.out.println(sol.peopleAwareOfSecret(n, delay, forget));

    }
}
