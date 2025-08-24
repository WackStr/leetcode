package com.wackstr.leetcode;

/*
2025-08-24
 */
public class LongestSubarray_1493 {
    public int longestSubarray(int[] nums) {
        // Number of zero's in the window.
        int zeroCount = 0;
        int longestWindow = 0;
        // Left end of the window.
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);

            // Shrink the window until the count of zero's
            // is less than or equal to 1.
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }

            longestWindow = Math.max(longestWindow, i - start);
        }

        return longestWindow;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        LongestSubarray_1493 sol = new LongestSubarray_1493();
        System.out.println(sol.longestSubarray(nums));
    }
}
