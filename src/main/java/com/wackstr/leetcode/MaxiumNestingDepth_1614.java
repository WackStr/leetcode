package com.wackstr.leetcode;

/*
2026-09-28 1614
 */
public class MaxiumNestingDepth_1614 {
    public int maxDepth(String s) {
        int res = 0;
        int curr = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if(c == '(') curr++;
            else if(c == ')') curr--;
            res = Math.max(res, curr);
        }
        return res;
    }
}
