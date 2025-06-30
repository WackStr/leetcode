package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-06-30
 */
public class HarmoniousSubsequence_495 {
    public int findLHS(int[] nums){
        Arrays.sort(nums);
        int left = 0;
        int max = 0;
        for(int right = 0; right < nums.length; right++){
            while(nums[right] - nums[left] > 1) left++;
            if(nums[right] - nums[left] == 1) max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        HarmoniousSubsequence_495 sol = new HarmoniousSubsequence_495();
        System.out.println(sol.findLHS(nums));
    }
}
