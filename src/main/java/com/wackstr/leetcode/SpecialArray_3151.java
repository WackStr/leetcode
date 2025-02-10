package com.wackstr.leetcode;

/*
2025-02-01
 */
public class SpecialArray_3151 {

    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1) return true;

        int lastBit = nums[0] & 1;
        for(int i = 1; i < nums.length; i++) {
            int currBit = nums[i] & 1;
            int parity = currBit ^ lastBit;
            if(parity == 0) return false;
            lastBit = currBit;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,6,2};
        SpecialArray_3151 sol = new SpecialArray_3151();
        System.out.println(sol.isArraySpecial(nums));
    }
}
