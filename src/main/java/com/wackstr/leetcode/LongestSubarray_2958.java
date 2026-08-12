package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
2026-08-12 2958
 */
public class LongestSubarray_2958 {
    public int maxSubarrayLength(int[] nums, int k){
        int left = 0;
        int n = nums.length;
        Map<Integer, Integer> counts = new HashMap<>();
        int res = 0;
        for (int right = 0; right < n; right++) {
            counts.put(nums[right], counts.getOrDefault(nums[right], 0) + 1);
            while(counts.get(nums[right]) > k){
                counts.computeIfPresent(nums[left], (key, val) -> val - 1 == 0 ? null : val - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,1,2};
        int k = 2;
        LongestSubarray_2958 sol = new LongestSubarray_2958();
        System.out.println(sol.maxSubarrayLength(nums, k));
    }
}
