package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-06-30
 */
public class HarmoniousSubsequence_495 {
    public int findLHS(int[] nums){
        Arrays.sort(nums);
        int max = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length) {
            while (right < nums.length && nums[right] - nums[left] <= 1) right++;
            if(nums[right-1] - nums[left] == 1) max = Math.max(max, right - left);
            if(right >= nums.length) break;
            while(left < right && nums[right] - nums[left] > 1) left++;
        }
        return max == 1 ? 0 : max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        HarmoniousSubsequence_495 sol = new HarmoniousSubsequence_495();
        System.out.println(sol.findLHS(nums));
    }
}
