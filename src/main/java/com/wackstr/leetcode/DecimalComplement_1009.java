package com.wackstr.leetcode;

/*
2026-03-11 1009
 */
public class DecimalComplement_1009 {
    public int bitwiseComplement(int n){
        return n == 0 ? 1 : n ^ ((Integer.highestOneBit(n) << 1) - 1);
    }

    public static void main(String[] args) {
        int n = 0;
        DecimalComplement_1009 sol = new DecimalComplement_1009();
        System.out.println(sol.bitwiseComplement(n));
    }
}
