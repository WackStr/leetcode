package com.wackstr.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
2026-02-10 3719
 */
public class BalancedSubarray_3719 {
    public int longestBalanced(int[] nums){
        int max = 0;
        Set<Integer> evenNumbers = new HashSet<>();
        Set<Integer> oddNumbers = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            evenNumbers.clear();
            oddNumbers.clear();
            if((nums[i] & 1) == 0) evenNumbers.add(nums[i]); else oddNumbers.add(nums[i]);
            for(int j = i + 1; j < nums.length; j++){
                if((nums[j] & 1) == 0) evenNumbers.add(nums[j]); else oddNumbers.add(nums[j]);
                if(evenNumbers.size() == oddNumbers.size()) max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}
