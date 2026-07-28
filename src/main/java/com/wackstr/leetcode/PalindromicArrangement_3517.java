package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-07-28 3517
 */
public class PalindromicArrangement_3517 {
    public String smallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        if(n == 1) return s;
        int m = arr.length / 2;
        int s2 = m + (n %  2 == 0 ? 0 :  1);
        Arrays.sort(arr, 0, m);
        for(int i = s2; i < n; i++){
            arr[i] = arr[n - i - 1];
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "babab";
        PalindromicArrangement_3517 sol = new PalindromicArrangement_3517();
        System.out.println(sol.smallestPalindrome(s));
    }
}
