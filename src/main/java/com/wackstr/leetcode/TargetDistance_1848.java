package com.wackstr.leetcode;

/*
2026-04-13 1848
 */
public class TargetDistance_1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        if(nums[start] == target) return 0;

        for(int i = 1; i < Math.min(nums.length - start, start + 1); i++){
            if(nums[start - i] == target) return i;
            if(nums[start + i] == target) return i;
        }
        if(nums.length - start > start){
            for(int i = 2 * start + 1; i < nums.length; i++){
                if(nums[i] == target) return (i - start);
            }
        }else{
            for(int i = 2 * start - nums.length - 1; i >= 0; i--){
                if(nums[i] == target) return (start - i);
            }
        }
        return -1;
    }
}
