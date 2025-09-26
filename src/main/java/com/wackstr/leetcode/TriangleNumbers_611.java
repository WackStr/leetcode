package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-09-26
 */
public class TriangleNumbers_611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        TriangleNumbers_611 sol = new TriangleNumbers_611();
        System.out.println(sol.triangleNumber(nums));
    }
}
