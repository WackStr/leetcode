package com.wackstr.leetcode.learn.HashMap;

import java.util.HashMap;
import java.util.Map;

public class NearDuplicates {
    public boolean containsNearbyDuplicate(int[] nums, int k){
        Map<Integer, Integer> idx = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer prev = idx.put(nums[i], i);
            if(prev != null && i - prev <= k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;

        NearDuplicates sol = new NearDuplicates();
        System.out.println(sol.containsNearbyDuplicate(nums, k));
    }
}
