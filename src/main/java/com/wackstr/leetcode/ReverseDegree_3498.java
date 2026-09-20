package com.wackstr.leetcode;

/*
2026-09-20 3498
 */
public class ReverseDegree_3498 {
    public int reverseDegree(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += (26 - arr[i] + 'a') * (i + 1);
        }
        return res;
    }
}
