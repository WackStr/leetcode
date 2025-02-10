package com.wackstr.leetcode;

/*
2024-1-3
 */
public class ArraySplit_2270 {
    public int waysToSplitArray(int[] nums){
        long sum = getSum(nums);
        int validCount = 0;
        long currSum = 0;
        for(int i = 0; i < nums.length - 1; i++){
            currSum += nums[i];
            validCount += currSum >= sum - currSum ? 1 : 0;
        }
        return validCount;
    }

    private long getSum(int[] nums) {
        long sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {10, 4, -8, 7};
        ArraySplit_2270 sol = new ArraySplit_2270();
        System.out.println(sol.waysToSplitArray(nums));
    }
}
