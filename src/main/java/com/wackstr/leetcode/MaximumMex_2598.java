package com.wackstr.leetcode;

/*
2025-10-16
 */
public class MaximumMex_2598 {
    public int findSmallestInteger(int[] nums, int value){
        int[] freq = new int[value];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0){
                nums[i] %= value;
                if(nums[i] < 0) nums[i] += value;
            }
            freq[nums[i]%value]++;
        }
        int mex = 0;
        while(true){
            int target = mex % value;
            if(freq[target] > 0){
                freq[target]--;
            }else{
                break;
            }
            mex++;
        }
        return mex;
    }

    public static void main(String[] args) {
        int[] nums = {1, -10, 7, 13,6, 8};
        int value = 5;
        MaximumMex_2598 sol = new MaximumMex_2598();
        System.out.println(sol.findSmallestInteger(nums, value));
    }
}
