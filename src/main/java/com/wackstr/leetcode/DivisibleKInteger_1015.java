package com.wackstr.leetcode;

/*
2025-11-25 1015
 */
public class DivisibleKInteger_1015 {
    public int smallestRepunitDivByK(int K) {
        int remainder = 0;
        for (int length_N = 1; length_N <= K; length_N++) {
            remainder = (remainder * 10 + 1) % K;
            if (remainder == 0) {
                return length_N;
            }
        }
        return -1;
    }
}
