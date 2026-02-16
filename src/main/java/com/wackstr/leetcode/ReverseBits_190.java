package com.wackstr.leetcode;

/*
2026-02-16 190
 */
public class ReverseBits_190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 43261596;
        ReverseBits_190 sol = new ReverseBits_190();
        System.out.println(sol.reverseBits(n));
    }
}
