package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-06-01 2144
 */
public class BuyingCandies_2144 {
    public int minimumCost(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int i = nums.length-1;
        for(int j = nums.length-1;j>=0;j--)
        {
            sum = sum + nums[j];
            if(i - j == 2)
            {
                sum = sum - nums[j];
                i = i - 3;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] cost = {1,2,3};
        BuyingCandies_2144 sol = new BuyingCandies_2144();
        System.out.println(sol.minimumCost(cost));
    }
}
