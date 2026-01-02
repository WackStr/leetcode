package com.wackstr.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
2026-01-02 961
 */
public class RepeatedItem_961 {
    public int repeatedNTimes(int[] nums){
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if(seen.contains(num)) return num;
            seen.add(num);
        }
        return -1;
    }
}
