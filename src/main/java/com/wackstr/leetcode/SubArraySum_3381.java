package com.wackstr.leetcode;

/*
2025-11-27 3381
 */
public class SubArraySum_3381 {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefixSum = 0;
        long maxSum = Long.MIN_VALUE;
        long[] kSum = new long[k];
        for (int i = 0; i < k; i++) {
            kSum[i] = Long.MAX_VALUE / 2;
        }
        kSum[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            maxSum = Math.max(maxSum, prefixSum - kSum[i % k]);
            kSum[i % k] = Math.min(kSum[i % k], prefixSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {13,-30,-29,48};
        int k = 1;
        SubArraySum_3381 sol = new SubArraySum_3381();
        System.out.println(sol.maxSubarraySum(nums, k));
    }
}
