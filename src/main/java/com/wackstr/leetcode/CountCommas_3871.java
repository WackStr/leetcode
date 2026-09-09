package com.wackstr.leetcode;

/*
2026-09-09 3871
 */
public class CountCommas_3871 {
    public long countCommas(long n) {
        long p = 1000, res = 0;
        while (p <= n) {
            res += n - p + 1;
            p *= 1000;
        }
        return res;
    }

    public static void main(String[] args) {
        long n = 3077;
        CountCommas_3871 sol = new CountCommas_3871();
        System.out.println(sol.countCommas(n));
    }
}
