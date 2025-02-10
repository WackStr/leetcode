package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
2025-02-09
 */
public class BadPairs_2364 {
    public long countBadPairs(int[] nums){
        Map<Integer, Integer> deltaPairs = new HashMap<>();
        int n = nums.length;
        long totalPairs = (long) n *(n-1)/2;
        for(int i = 0; i < n; i++){
            deltaPairs.merge(nums[i] - i, 1, Integer::sum);
        }
        for(Map.Entry<Integer, Integer> entry : deltaPairs.entrySet()){
            int pairs = entry.getValue();
            totalPairs -= pairs > 1 ? (long) pairs * (pairs - 1) / 2 : 0;
        }
        return totalPairs;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 3};
        BadPairs_2364 sol = new BadPairs_2364();
        System.out.println(sol.countBadPairs(nums));
    }
}
