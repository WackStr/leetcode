package com.wackstr.leetcode;

/*
2025-03-18
 */
public class LongestNiceSubarray_2401 {
    public int longestNiceSubarray(int[] nums) {
        int usedBits = 0; // Tracks bits used in current window
        int windowStart = 0; // Start position of current window
        int maxLength = 0; // Length of longest nice subarray found

        for (int windowEnd = 0; windowEnd < nums.length; ++windowEnd) {
            // If current number shares bits with window, shrink window from left
            // until there's no bit conflict
            while ((usedBits & nums[windowEnd]) != 0) {
                usedBits ^= nums[windowStart]; // Remove leftmost element's bits
                windowStart++;
            }

            // Add current number to the window
            usedBits |= nums[windowEnd];

            // Update max length if current window is longer
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,8,48,10};
        LongestNiceSubarray_2401 sol = new LongestNiceSubarray_2401();
        System.out.println(sol.longestNiceSubarray(nums));
    }
}
