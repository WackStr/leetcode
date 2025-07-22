package com.wackstr.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
2025-07-22
 */
public class MaximumErasure_1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int result = 0, currentSum = 0, start = 0;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            while (seen.contains(num)) {
                seen.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            currentSum += num;
            seen.add(num);
            result = Math.max(result, currentSum);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,1,2,5,2,1,2,5};
        MaximumErasure_1695 sol = new MaximumErasure_1695();
        System.out.println(sol.maximumUniqueSubarray(nums));
    }
}
