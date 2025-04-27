package com.wackstr.leetcode;

/*
2025-04-27
 */
public class CountSubarray_3392 {
    public int countSubarrays(int[] nums){
        int res = 0;
        for(int i = 0; i < nums.length - 2; i++){
            res += (nums[i] + nums[i+2]) * 2 == nums[i+1] ? 1 : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        CountSubarray_3392 sol = new CountSubarray_3392();
        System.out.println(sol.countSubarrays(nums));
    }
}
