package com.wackstr.leetcode;

public class PowerSum_2787 {

    final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = (int) Math.pow(i, x);
            if (val > n) {
                break;
            }
            for (int j = n; j >= val; j--) {
                dp[j] = (dp[j] + dp[j - val]) % MOD;
            }
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int x = 2;
        PowerSum_2787 sol = new PowerSum_2787();
        System.out.println(sol.numberOfWays(n, x));
    }
}
