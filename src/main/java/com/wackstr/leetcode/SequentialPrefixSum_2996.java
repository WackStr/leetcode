package com.wackstr.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
2026-8-11 2996
 */
public class SequentialPrefixSum_2996 {
    public int missingInteger(int[] nums) {
        int prefixSum = nums[0];
        int n = nums.length;
        int i = 1;
        Set<Integer> set = new HashSet<>();

        set.add(nums[0]);
        while(i < n && nums[i] == nums[i-1]+1){
            prefixSum += nums[i];
            set.add(nums[i]);
            i++;
        }
        while(i < n){
            set.add(nums[i]);
            i++;
        }
        while(set.contains(prefixSum)) prefixSum++;
        return prefixSum;
    }

    public static void main(String[] args) {
        int[] nums = {38};
        SequentialPrefixSum_2996 sol = new SequentialPrefixSum_2996();
        System.out.println(sol.missingInteger(nums));
    }
}
