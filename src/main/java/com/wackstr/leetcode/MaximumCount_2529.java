package com.wackstr.leetcode;

/*
2025-03-12
 */
public class MaximumCount_2529 {
    public int maximumCount(int[] nums){
        if(nums[0] > 0 || nums[nums.length - 1] < 0) return nums.length;
        else if (nums[0] == 0 && nums[nums.length - 1] == 0) return 0;
        else if(nums[0] == 0){
            int i = 0;
            while(i < nums.length && nums[i] == 0) i++;
            return nums.length - i;

        }else{
            int i = 0;
            while(i < nums.length && nums[i] < 0) i++;
            int neg = i;
            while(i < nums.length && nums[i] == 0) i++;
            int pos = nums.length - i;
            return Math.max(neg, pos);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        MaximumCount_2529 sol = new MaximumCount_2529();
        System.out.println(sol.maximumCount(nums));
    }
}
