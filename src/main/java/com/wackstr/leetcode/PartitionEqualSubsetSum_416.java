package com.wackstr.leetcode;

import java.util.*;

/*
2025-04-07
 */
public class PartitionEqualSubsetSum_416 {
    // this is the 0-1 knapsack
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }

    private static boolean canParitionBottomUp(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for(int i = nums.length - 1; i >= 0; i--){
            Set<Integer> nextDp = new HashSet<>();
            for(int num : dp){
                if(num + nums[i] == target) return true;
                nextDp.add(num + nums[i]);
                nextDp.add(num);
            }
            dp = nextDp;
        }
        return dp.contains(target);
    }

    private boolean canPartitionBackTracking(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int num : nums) sum += num;
        Map<Integer, Map<Integer, Boolean>> cache = new HashMap<>();
        if((sum & 1) == 1) return false;
        return canSum(0, sum / 2, nums, 0, cache);
    }

    public boolean canSum(int curr, int target, int[] nums, int i, Map<Integer, Map<Integer, Boolean>> cache){
        if(i >= nums.length || curr > target || nums[i] > target - curr) return false;
        if(curr == target || nums[i] + curr == target) return true;
        if(cache.containsKey(i) && cache.get(i).containsKey(target - curr)) return cache.get(i).get(target - curr);
        boolean with = canSum(curr + nums[i], target, nums, i + 1, cache);
        boolean without = canSum(curr, target, nums, i+1, cache);
        boolean res = with || without;
        cache.computeIfAbsent(i, k -> new HashMap<>()).put(target - curr, res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        PartitionEqualSubsetSum_416 sol = new PartitionEqualSubsetSum_416();
        System.out.println(sol.canPartition(nums));
    }
}
