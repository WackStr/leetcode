package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> idxLookup = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            int complementIndex = idxLookup.getOrDefault(complement, -1);
            if(complementIndex != -1){
                return new int[]{complementIndex, i};
            }else{
                idxLookup.put(nums[i], i);
            }
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        TwoSum sol = new TwoSum();
        System.out.println(Arrays.toString(sol.twoSum(nums, target)));
    }
}
