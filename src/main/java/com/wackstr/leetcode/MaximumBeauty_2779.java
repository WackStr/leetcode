package com.wackstr.leetcode;

import java.util.Arrays;

/*
2024-12-11
 */
public class MaximumBeauty_2779 {
    public int maximumBeauty(int[] nums, int k){
        Arrays.sort(nums);
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            int limit = 2 * k + currNum;

            int left = i;
            int right = nums.length - 1;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(mid == left) mid++;
                if(nums[mid] > limit) right = mid - 1;
                else left = mid;
            }
            max = Math.max(max, left - i + 1);
        }
        return max;
    }

    public int maximumBeauty_countOverlap(int[] nums, int k) {
        // If there's only one element, the maximum beauty is 1
        if (nums.length == 1) return 1;

        int maxBeauty = 0;
        int maxValue = 0;

        // Find the maximum value in the array
        for (int num : nums) maxValue = Math.max(maxValue, num);

        // Create an array to keep track of the count changes
        int[] count = new int[maxValue + 1];

        // Update the count array for each value's range [val - k, val + k]
        for (int num : nums) {
            count[Math.max(num - k, 0)]++; // Increment at the start of the range
            count[Math.min(num + k + 1, maxValue)]--; // Decrement after the range
        }

        int currentSum = 0; // Tracks the running sum of counts
        // Calculate the prefix sum and find the maximum value
        for (int val : count) {
            currentSum += val;
            maxBeauty = Math.max(maxBeauty, currentSum);
        }

        return maxBeauty;
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 1, 2};
        int k = 2;
        MaximumBeauty_2779 sol = new MaximumBeauty_2779();
        System.out.println(sol.maximumBeauty(nums, k));
    }
}
