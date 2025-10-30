package com.wackstr.leetcode;

/*
2025-10-30
 */
public class IncrementSubarrays_1526 {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int ans = target[0];
        for (int i = 1; i < n; ++i) {
            ans += Math.max(target[i] - target[i - 1], 0);
        }
        return ans;
    }
}
