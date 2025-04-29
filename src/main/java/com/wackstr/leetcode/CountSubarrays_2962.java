package com.wackstr.leetcode;

/*
2025-04-29
 */
public class CountSubarrays_2962 {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxVal = 0;
        for (int v : nums) maxVal = Math.max(maxVal, v);

        long res = 0;
        int count = 0, left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == maxVal) count++;
            while (count >= k) {
                if (nums[left] == maxVal) count--;
                left++;
            }
            res += left;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 1};
        int k = 3;
        CountSubarrays_2962 sol = new CountSubarrays_2962();
        System.out.println(sol.countSubarrays(nums, k));
    }
}
