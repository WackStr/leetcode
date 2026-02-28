package com.wackstr.leetcode;

/*
2026-02-28 1680
 */
public class ConcatenateBinary_1680 {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long res = 0;
        int bits = 0;

        for(int i=1; i<=n; i++){
            if((i & (i-1)) == 0) bits++;
            res = ((res<<bits) | i) % MOD;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 0b11;
        ConcatenateBinary_1680 sol = new ConcatenateBinary_1680();
        System.out.println(Integer.numberOfTrailingZeros(Integer.highestOneBit(k))+1);
        System.out.println(sol.concatenatedBinary(n));
    }
}
