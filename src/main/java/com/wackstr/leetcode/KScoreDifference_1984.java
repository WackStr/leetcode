package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-01-25 1984
 */
public class KScoreDifference_1984 {
    public int minimumDifference(int[] nums, int k){
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length - k; i++)
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {90};
        KScoreDifference_1984 sol = new KScoreDifference_1984();
        System.out.println(sol.minimumDifference(nums, 1));
    }
}
