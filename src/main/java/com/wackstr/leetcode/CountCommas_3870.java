package com.wackstr.leetcode;

/*
2026-09-08 3870
 */
public class CountCommas_3870 {
    public int countCommas(int n) {
        if(n<1000){
            return 0;
        }
        return n - 999;
    }

    public static void main(String[] args) {
        int n = 2019;
        CountCommas_3870 sol = new CountCommas_3870();
        System.out.println(sol.countCommas(n));
    }
}
