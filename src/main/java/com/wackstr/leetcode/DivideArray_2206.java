package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
2025-03-17
 */
public class DivideArray_2206 {
    public boolean divideArray(int[] nums){
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.merge(num, 1, Integer::sum);
        }
        for(int val : count.values()){
            if(val % 2 != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        DivideArray_2206 sol = new DivideArray_2206();
        System.out.println(sol.divideArray(nums));
    }
}
