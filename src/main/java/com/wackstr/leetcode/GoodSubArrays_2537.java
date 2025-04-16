package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
2025-04-16
 */
public class GoodSubArrays_2537 {

    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int same = 0, right = -1;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        long ans = 0;
        for (int left = 0; left < n; ++left) {
            while (same < k && right + 1 < n) {
                ++right;
                same += cnt.getOrDefault(nums[right], 0);
                cnt.put(nums[right], cnt.getOrDefault(nums[right], 0) + 1);
            }
            if (same >= k) {
                ans += n - right;
            }
            cnt.put(nums[left], cnt.get(nums[left]) - 1);
            same -= cnt.get(nums[left]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 3, 2, 2, 4};
        int k = 2;
        GoodSubArrays_2537 sol = new GoodSubArrays_2537();
        System.out.println(sol.countGood(nums, k));
    }
}
