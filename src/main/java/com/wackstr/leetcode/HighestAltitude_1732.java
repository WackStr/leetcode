package com.wackstr.leetcode;

/*
2026-06-19 1732
 */
public class HighestAltitude_1732 {
    public int largestAltitude(int[]  gain){
        int res = 0;
        int curr = 0;
        for (int i : gain) {
            curr += i;
            res = Math.max(res, curr);
        }
        return res;
    }
}
