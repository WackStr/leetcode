package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-06-19
 */
public class ArrayPartitions_2294 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int rec = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - rec > k) {
                ans++;
                rec = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 4, 5};
        int k = 0;
        ArrayPartitions_2294 sol = new ArrayPartitions_2294();
        System.out.println(sol.partitionArray(nums, k));
    }
}
