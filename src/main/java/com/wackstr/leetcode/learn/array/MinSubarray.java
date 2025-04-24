package com.wackstr.leetcode.learn.array;

public class MinSubarray {
    /*
    Given an array of positive integers nums and a positive integer target,
    return the minimal length of a subarray whose sum is greater than or
    equal to target. If there is no such subarray, return 0 instead.
     */
    public int minSubArrayLen(int target, int[] nums){
        int left = 0;
        int currSum = 0;
        int minArr = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){
            currSum += nums[right];
            while(currSum >= target && left <= right){
                minArr = Math.min(minArr, right - left + 1);
                currSum -= nums[left++];
            }
        }
        return minArr == Integer.MAX_VALUE ? 0 : minArr;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        MinSubarray sol = new MinSubarray();
        System.out.println(sol.minSubArrayLen(target, nums));
    }
}
