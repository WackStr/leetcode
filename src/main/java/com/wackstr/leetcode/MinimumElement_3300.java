package com.wackstr.leetcode;

/*
2026-05-29 3300
 */
public class MinimumElement_3300 {
    public int minElement(int[] nums){
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int curr = 0;
            while(num > 0){
                curr += num % 10;
                num /= 10;
            }
            min = Math.min(min, curr);
        }
        return min;
    }
}
