package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.List;

/*
2026-01-20
 */
public class BitwiseArray_3314 {
    public int[] minBitwiseArray(List<Integer> nums){
        int[] res = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            // check for two
            if((num & 1) == 0) res[i] = -1;
            else{
                int part = 0;
                int test = num;
                while((test & 1) == 1){
                    part = (part << 1) | 1;
                    test >>= 1;
                }
                res[i] = (num ^ part) + (part >> 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{11,13,31};
        BitwiseArray_3314 sol = new BitwiseArray_3314();
        System.out.println(Arrays.toString(sol.minBitwiseArray(Arrays.asList(nums))));
    }
}
