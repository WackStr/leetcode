package com.wackstr.leetcode;

import java.util.Arrays;

public class AdjArrayElem_3405 {

    private static final int MOD = 1_000_000_007;
    private static final int MX = 100000;
    private static long[] fact = new long[MX];
    private static long[] invFact = new long[MX];

    static long qpow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }

    static {
        fact[0] = 1;
        for (int i = 1; i < MX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MX - 1] = qpow(fact[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            invFact[i - 1] = (invFact[i] * i) % MOD;
        }
    }

    long comb(int n, int m) {
        return (((fact[n] * invFact[m]) % MOD) * invFact[n - m]) % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        return (int) ((((comb(n - 1, k) * m) % MOD) * qpow(m - 1, n - k - 1)) %
                MOD);
    }

    private int dynamicSolution(int n, int m, int k) {
        int res = 0;
        int[][] dp = new int[n][k + 1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        for(int i = 1; i <= m; i++){
            res += count(0, i, 0, n, m, k, dp);
            res %= MOD;
        }
        return res;
    }

    private int count(int index, int lastNumber, int pairCount,int n, int m, int k, int[][] dp) {
        if(index == n - 1) return pairCount == k ? 1 : 0;
        if(dp[index][pairCount] != -1) return dp[index][pairCount];
        int res = 0;
        for(int i = 1; i <= m; i++){
            if(i == lastNumber){
                if(pairCount < k) {
                    res += count(index + 1, i, pairCount + 1, n, m, k, dp);
                }
            }else{
                res += count(index + 1, i, pairCount, n, m, k, dp);
            }
            res %= MOD;
        }
        dp[index][pairCount] = res;
        return res;
    }

    public static void main(String[] args) {
        int n = 3, m = 2, k = 1;
        AdjArrayElem_3405 sol = new AdjArrayElem_3405();
        System.out.println(sol.countGoodArrays(n, m, k));
    }
}
