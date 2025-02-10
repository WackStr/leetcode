package com.wackstr.leetcode;

/*
2024-12-26
 */
public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int target){
        int cnt = 0;
        int n = nums.length;
        int[] sums = new int[n];
        sums[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            sums[i] = nums[i] + sums[i+1];
        }
        return
                track(nums, sums, -nums[0], 1, target) +
                        track(nums, sums, nums[0], 1, target);
    }

    public int track(int[] nums, int[] sums, int currSum, int index, int target){
        if(index >= nums.length) return currSum == target ? 1 : 0;
        int requiredSum = target - currSum;
        if(requiredSum >= -sums[index-1] && requiredSum <= sums[index-1]){
            return
                    track(nums, sums, currSum - nums[index], index + 1, target) +
                            track(nums, sums, currSum + nums[index], index + 1, target);
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        TargetSum_494 sol = new TargetSum_494();
        System.out.println(sol.findTargetSumWays(nums,target));
    }
}
