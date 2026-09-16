package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-09-16 1621
 */
public class NonOverlappingLineSegments_1621 {

    private static final long MOD = 1000000007L;

    private long quickPow(long a, long e) {
        long result = 1;
        while (e > 0) {
            if ((e & 1) != 0) result = (result * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return result;
    }

    public int numberOfSets(int n, int k) {
        int m = 2 * k;
        long numerator = 1, denominator = 1;
        for (int i = 1; i <= m; i++) {
            numerator = (numerator * (n + k - i)) % MOD;
            denominator = (denominator * i) % MOD;
        }
        return (int) ((numerator * quickPow(denominator, MOD - 2)) % MOD);
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        NonOverlappingLineSegments_1621 sol = new NonOverlappingLineSegments_1621();
        System.out.println(sol.numberOfSets(n, k));
    }
}
