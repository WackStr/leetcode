package com.wackstr.leetcode.learn.array;

public class PivotIndex {
    public int pivotIndex(int[] nums){
        int sum = 0;
        for(int num : nums) sum += num;
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
