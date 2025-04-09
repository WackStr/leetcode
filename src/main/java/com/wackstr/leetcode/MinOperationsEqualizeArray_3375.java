package com.wackstr.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
2025-04-09
 */
public class MinOperationsEqualizeArray_3375 {

    public int minOperations(int[] nums, int k){
        Set<Integer> distinctIntegers = new HashSet<>();
        for(int num : nums){
            if(num < k) return -1;
            else if(num > k) distinctIntegers.add(num);
        }
        return distinctIntegers.size();
    }

    public static void main(String[] args) {
        int[] nums = {9, 7, 5, 3};
        int k = 1;
        MinOperationsEqualizeArray_3375 sol =
                new MinOperationsEqualizeArray_3375();
        System.out.println(sol.minOperations(nums, k));
    }
}
