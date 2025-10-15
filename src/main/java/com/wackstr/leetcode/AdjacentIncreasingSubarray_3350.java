package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.List;

/*
2025-10-15
 */
public class AdjacentIncreasingSubarray_3350 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int max = 0;
        int left = 0;
        int right = 1;
        int lastDelta = 0;
        while(left <= nums.size()) {
            while (right < nums.size() && nums.get(right) > nums.get(right - 1)) {
                right++;
            }
            int delta = right - left;
            max = Math.max(max, delta/2);
            max = Math.max(max, Math.min(delta, lastDelta));
            left = right;
            right++;
            lastDelta = delta;
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(19,4,19,6,18);
        AdjacentIncreasingSubarray_3350 sol =
                new AdjacentIncreasingSubarray_3350();
        System.out.println(sol.maxIncreasingSubarrays(nums));
    }
}
