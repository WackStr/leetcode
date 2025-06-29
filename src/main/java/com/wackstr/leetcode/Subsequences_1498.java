package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-06-29
 */
public class Subsequences_1498 {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007 , n = nums.length;
        Arrays.sort(nums);

        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        int left = 0 , right = n - 1 , result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,6,7};
        int target = 9;
        Subsequences_1498 sol = new Subsequences_1498();
        System.out.println(sol.numSubseq(nums, target));
    }
}
