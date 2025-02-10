package com.wackstr.leetcode;

/*
2025-02-03
 */
public class MonotonicSubArray_3105 {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 1) return 1;
        int length = 1;
        int left = 0;
        int right = 1;
        boolean isIncreasing = nums[right] > nums[left];
        while(left < nums.length && right < nums.length){
            while(left < nums.length && right < nums.length && nums[left] == nums[right]){
                left++;
                right++;
            }
            if(right < nums.length){
                isIncreasing = nums[right] > nums[left];
            }
            while(right < nums.length && (isIncreasing ? nums[right] > nums[right - 1] : nums[right] < nums[right - 1])){
              right++;
            }
            length = Math.max(length, right - left);
            left = right - 1;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,3,2};
        MonotonicSubArray_3105 sol = new MonotonicSubArray_3105();
        System.out.println(sol.longestMonotonicSubarray(nums));
    }
}
