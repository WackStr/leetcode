package com.wackstr.leetcode;

/*
2026-03-05 1758
 */
public class AlternatingBinary_1758 {
    public int minOperations(String s){
        int n = s.length();
        int res = 0;
        for (int i = 0; i < s.length(); i+=2) {
            if (s.charAt(i) == '0') res++;
        }
        for (int i = 1; i < s.length(); i+=2) {
            if (s.charAt(i) == '1') res++;
        }
        return Math.min(res, n - res);
    }

    public static void main(String[] args) {
        String s = "01010";
        AlternatingBinary_1758 sol = new AlternatingBinary_1758();
        System.out.println(sol.minOperations(s));
    }
}
