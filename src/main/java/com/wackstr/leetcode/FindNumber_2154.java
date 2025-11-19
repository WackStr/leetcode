package com.wackstr.leetcode;

/*
2025-11-19
 */
public class FindNumber_2154 {
    public int findFinalValue(int[] nums, int original) {
        boolean[] exists = new boolean[1001];
        for (int num : nums) {
            exists[num] = true;
        }
        int curr = original;
        while(curr <= 1000 && exists[curr]){
            curr *= 2;
        }
        return curr;
    }
}
