package com.wackstr.leetcode;

/*
2026-04-20 2078
 */
public class DifferentPairs_2078 {
    public int maxDistance(int[] colors) {
        int res = 0;
        int n = colors.length - 1;
        for(int i = 0; i < colors.length; i++){
            if(colors[i] != colors[0]) res = Math.max(res, i);
            if(colors[i] != colors[n]) res = Math.max(res, n - i);
        }
        return res;
    }
}
